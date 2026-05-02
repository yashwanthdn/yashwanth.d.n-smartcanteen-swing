package smartcanteen;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class OrderDAO {
	public static void placeOrder(int userId, int foodId, int qty) {
        try (Connection con = DBConnection.getConnection()) {

            String orderSql = "INSERT INTO orders(user_id,order_date,status) VALUES(?,?,?)";
            PreparedStatement orderPs = con.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
            orderPs.setInt(1, userId);
            orderPs.setDate(2, Date.valueOf(LocalDate.now()));
            orderPs.setString(3, "PLACED");
            orderPs.executeUpdate();

            ResultSet rs = orderPs.getGeneratedKeys();
            rs.next();
            int orderId = rs.getInt(1);

            String itemSql = "INSERT INTO order_items(order_id,food_id,quantity) VALUES(?,?,?)";
            PreparedStatement itemPs = con.prepareStatement(itemSql);
            itemPs.setInt(1, orderId);
            itemPs.setInt(2, foodId);
            itemPs.setInt(3, qty);
            itemPs.executeUpdate();

            System.out.println("Order placed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewMyOrders(int userId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = """
                SELECT o.order_id, f.food_name, oi.quantity, o.order_date, o.status
                FROM orders o
                JOIN order_items oi ON o.order_id = oi.order_id
                JOIN food_items f ON oi.food_id = f.food_id
                WHERE o.user_id = ?
                """;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("order_id") + " | " +
                        rs.getString("food_name") + " | Qty: " +
                        rs.getInt("quantity") + " | " +
                        rs.getDate("order_date") + " | " +
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewAllOrders() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("""
                SELECT o.order_id, u.name, o.order_date, o.status
                FROM orders o JOIN users u ON o.user_id = u.user_id
                """);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("order_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDate("order_date") + " | " +
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
