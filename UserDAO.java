package smartcanteen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO {
	public static void register(String name, String email, String password) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
            System.out.println("Registration successful!");
        } catch (Exception e) {
            System.out.println("Registration failed!");
        }
    }

    public static int login(String email, String password) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT user_id FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
