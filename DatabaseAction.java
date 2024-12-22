import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseAction {
    public static ArrayList<Player> query(String name, String nation, Integer age, Integer ability, String division, String position) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM PlayerAttributes WHERE 1=1");
        // The basic database query. The every other parameters applied to the end of this string
        ArrayList<Object> parameters = new ArrayList<>();

        // For searching by name
        if (name != null && !name.trim().isEmpty()) {
            queryBuilder.append(" AND Name LIKE ?");
            parameters.add("%" + name + "%");
        }
        //  For searching by nation
        if (nation != null && !nation.trim().isEmpty()) {
            queryBuilder.append(" AND Nati = ?");
            parameters.add(nation);
        }
        // For searching by age
        if (age != -1) {
            queryBuilder.append(" AND Age = ?");
            parameters.add(age);
        }
        // For searching by overall
        if (ability != -1) {
            queryBuilder.append(" AND CA = ?");
            parameters.add(ability);
        }
        // For searching by League
        if (division != null && !division.trim().isEmpty()) {
            queryBuilder.append(" AND Division = ?");
            parameters.add(division);
        }
        // For searching by positions
        if (position != null && !position.trim().isEmpty()) {
            queryBuilder.append(" AND Position LIKE ?");
            parameters.add("%" + position + "%");
        }
        // Final form of the query
        String query = queryBuilder.toString();
        ArrayList<Player> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery() ) {
                Map<Integer, Player> playerMap = new HashMap<>(); // For the players have multiple position.

                while (rs.next()) {
                    int playerId = rs.getInt("ID");

                    // Adds only the new position, if the player already exists
                    Player player = playerMap.getOrDefault(playerId, new Player(
                            rs.getString("Name"),
                            playerId,
                            rs.getInt("CA"),
                            rs.getString("Nati"),
                            rs.getInt("Age"),
                            rs.getString("Club"),
                            rs.getString("Division"),
                            rs.getString("Position") // Adds the first positin
                    ));

                    String pos = rs.getString("Position");
                    if (pos != null && !player.getPositions().contains(pos)) {
                        player.addPosition(pos); // Adds other positions
                    }

                    playerMap.put(playerId, player); // Add to Map
                }

                // Adds the map to the list
                results.addAll(playerMap.values());

            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return results;
    }
}
