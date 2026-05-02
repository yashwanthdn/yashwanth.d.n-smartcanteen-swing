package smartcanteen;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/smart_canteen_gui";
        String user = "root";
        String pass = "Gokul@19@69!";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

}
