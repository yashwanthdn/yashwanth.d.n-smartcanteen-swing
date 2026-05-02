package smartcanteen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FoodDAO {
	public static void addFood(String name, double price) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO food_items(food_name,price,availability) VALUES(?,?,true)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.executeUpdate();
            System.out.println("Food item added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePrice(int foodId, double price) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE food_items SET price=? WHERE food_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, price);
            ps.setInt(2, foodId);
            ps.executeUpdate();
            System.out.println("Price updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFood(int foodId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM food_items WHERE food_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, foodId);
            ps.executeUpdate();
            System.out.println("Food deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewMenu() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food_items WHERE availability=true");
            System.out.println("\n--- MENU ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("food_id") + " | " +
                        rs.getString("food_name") + " | ₹" +
                        rs.getDouble("price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
