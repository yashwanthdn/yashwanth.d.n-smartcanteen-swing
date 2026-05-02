package smartcanteen;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	JTextField emailField;
    JPasswordField passwordField;

    public MainFrame() {
        setTitle("Smart Canteen System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginBtn = new JButton("Customer Login");
        JButton registerBtn = new JButton("Register");
        JButton staffBtn = new JButton("Staff Login");

        add(loginBtn);
        add(registerBtn);
        add(staffBtn);

        // LOGIN
        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());

            int userId = UserDAO.login(email, pass);
            if (userId != -1) {
                new CustomerDashboard(userId);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login");
            }
        });

        // REGISTER
        registerBtn.addActionListener(e -> {
            new RegisterFrame();
        });

        // STAFF LOGIN
        staffBtn.addActionListener(e -> {
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());

            if (StaffDAO.login(email, pass)) {
                new StaffDashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid staff login");
            }
        });

        setVisible(true);
    }


	public static void main(String[] args) {
        new MainFrame();

	}

}
