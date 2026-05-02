package smartcanteen;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StaffDashboard extends JFrame {
	public StaffDashboard() {
        setTitle("Staff Panel");
        setSize(400, 300);
        setLayout(new GridLayout(4,1));

        JButton add = new JButton("Add Food");
        JButton update = new JButton("Update Price");
        JButton delete = new JButton("Delete Food");

        add(add);
        add(update);
        add(delete);

        // ADD FOOD
        add.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Food Name");
            double price = Double.parseDouble(
                    JOptionPane.showInputDialog("Price"));

            FoodDAO.addFood(name, price);
        });

        // UPDATE
        update.addActionListener(e -> {
            int id = Integer.parseInt(
                    JOptionPane.showInputDialog("Food ID"));

            double price = Double.parseDouble(
                    JOptionPane.showInputDialog("New Price"));

            FoodDAO.updatePrice(id, price);
        });

        // DELETE
        delete.addActionListener(e -> {
            int id = Integer.parseInt(
                    JOptionPane.showInputDialog("Food ID"));

            FoodDAO.deleteFood(id);
        });

        setVisible(true);
    }


}
