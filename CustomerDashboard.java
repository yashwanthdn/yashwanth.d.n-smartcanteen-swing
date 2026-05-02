package smartcanteen;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomerDashboard extends JFrame {
	int userId;
    JTextArea menuArea;

    public CustomerDashboard(int userId) {
        this.userId = userId;

        setTitle("Customer Dashboard");
        setSize(500, 400);
        setLayout(new BorderLayout());

        menuArea = new JTextArea();
        add(new JScrollPane(menuArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();

        JButton viewMenu = new JButton("View Menu");
        JButton orderBtn = new JButton("Place Order");

        panel.add(viewMenu);
        panel.add(orderBtn);

        add(panel, BorderLayout.SOUTH);

        viewMenu.addActionListener(e -> loadMenu());

        orderBtn.addActionListener(e -> {
            String foodId = JOptionPane.showInputDialog("Food ID:");
            String qty = JOptionPane.showInputDialog("Quantity:");

            OrderDAO.placeOrder(userId,
                    Integer.parseInt(foodId),
                    Integer.parseInt(qty));

            JOptionPane.showMessageDialog(this, "Order placed!");
        });

        setVisible(true);
    }

    private void loadMenu() {
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT * FROM food_items WHERE availability=true");

            menuArea.setText("");

            while (rs.next()) {
                menuArea.append(
                        rs.getInt("food_id") + " | " +
                        rs.getString("food_name") + " | ₹" +
                        rs.getDouble("price") + "\n"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
