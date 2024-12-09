import java.sql.*;
import java.util.ArrayList;

public class DatabaseAction {
    public static ResultSet quary(String word) {
        String query = "SELECT * FROM PlayerAttributes WHERE Name LIKE ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Parametreyi ayarla
            pstmt.setString(1, "%" + word + "%");

            // Sorguyu çalıştır ve sonucu döndür
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        }
    }
    public static ArrayList<Player> search(String word) {
        ResultSet output = quary(word);
        ArrayList<Player> resultPlayers = new ArrayList<>();
        try{
            int i = 0;
            while (output.next()) {
                resultPlayers.add(new Player());
                resultPlayers.get(i).setName(output.getString("Name"));
                resultPlayers.get(i).setAge(output.getInt("Age"));
                resultPlayers.get(i).setNation(output.getString("Nat"));
                resultPlayers.get(i).setTeam_name(output.getString("Club"));
                resultPlayers.get(i).setLeague(output.getString("Division"));
            }
        }catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return resultPlayers;
    }

}
