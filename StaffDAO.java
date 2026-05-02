package smartcanteen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class StaffDAO {
	public static boolean login(String username, String password) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM staff WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

}
