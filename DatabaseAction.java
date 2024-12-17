import java.sql.*;
import java.util.ArrayList;

public class DatabaseAction {
    public static ArrayList<Player> query(String name, String nation, Integer age, Integer ability, String division) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM PlayerAttributes WHERE 1=1");
        ArrayList<Object> parameters = new ArrayList<>();

        if (name != null && !name.trim().isEmpty()) {
            queryBuilder.append(" AND Name LIKE ?");
            parameters.add("%" + name + "%");
        }
        if (nation != null && !nation.trim().isEmpty()) {
            queryBuilder.append(" AND Nati = ?");
            parameters.add(nation);
        }
        if (age != null) {
            queryBuilder.append(" AND Age = ?");
            parameters.add(age);
        }
        if (ability != null) {
            queryBuilder.append(" AND CA = ?");
            parameters.add(ability);
        }
        if (division != null && !division.trim().isEmpty()) {
            queryBuilder.append(" AND Division = ?");
            parameters.add(division);
        }

        String query = queryBuilder.toString();
        ArrayList<Player> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    results.add(new Player(
                            rs.getString("Name"),
                            rs.getInt("ID"),
                            rs.getInt("CA"),
                            rs.getString("Nati"),
                            rs.getInt("Age"),
                            rs.getString("Club"),
                            rs.getInt("Height")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return results;
    }
}
