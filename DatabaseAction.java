import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseAction {
    public static ArrayList<Player> query(String name, String nation, Integer age, Integer ability, String division, String position) {
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
        if (position != null && !position.trim().isEmpty()) {
            queryBuilder.append(" AND Position LIKE ?");
            parameters.add("%" + position + "%"); // Pozisyonu oyuncunun listesinde ara
        }

        String query = queryBuilder.toString();
        ArrayList<Player> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                Map<Integer, Player> playerMap = new HashMap<>(); // Aynı oyuncuya ait birden fazla pozisyon eklemek için map

                while (rs.next()) {
                    int playerId = rs.getInt("ID");

                    // Eğer oyuncu zaten mapte varsa, mevcut pozisyonu ekle
                    Player player = playerMap.getOrDefault(playerId, new Player(
                            rs.getString("Name"),
                            playerId,
                            rs.getInt("CA"),
                            rs.getString("Nati"),
                            rs.getInt("Age"),
                            rs.getString("Club"),
                            rs.getString("Division"),
                            rs.getString("Position") // İlk pozisyonu ekliyoruz
                    ));

                    // Pozisyonu ekle
                    String pos = rs.getString("Position");
                    if (pos != null && !player.getPositions().contains(pos)) {
                        player.addPosition(pos); // Pozisyonları ekle
                    }

                    playerMap.put(playerId, player); // Map'e ekle
                }

                // Map'teki oyuncuları results listesine ekle
                results.addAll(playerMap.values());

            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return results;
    }
}
