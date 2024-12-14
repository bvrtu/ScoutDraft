import java.sql.*;
import java.util.ArrayList;

public class DatabaseAction {
    public static ArrayList<Player> query(String name) {
        String query = "SELECT * FROM PlayerAttributes WHERE Name LIKE ?";
        ArrayList<Player> results = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + name + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    results.add( new Player(rs.getString("Name"),rs.getInt("ID"),
                            0,rs.getString("Nat"), rs.getInt("Age"),
                            rs.getString("Club"), rs.getInt("height")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return results;
    }
}
