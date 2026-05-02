package smartcanteen;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame {
	 public RegisterFrame() {
	        setTitle("Register");
	        setSize(300, 250);
	        setLayout(new GridLayout(4,2));

	        JTextField name = new JTextField();
	        JTextField email = new JTextField();
	        JPasswordField pass = new JPasswordField();

	        add(new JLabel("Name")); add(name);
	        add(new JLabel("Email")); add(email);
	        add(new JLabel("Password")); add(pass);

	        JButton btn = new JButton("Register");
	        add(btn);

	        btn.addActionListener(e -> {
	            UserDAO.register(name.getText(), email.getText(), new String(pass.getPassword()));
	            JOptionPane.showMessageDialog(this, "Registered!");
	            dispose();
	        });

	        setVisible(true);
	    }

}
