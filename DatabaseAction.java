import java.sql.*;
import java.util.ArrayList;

public class DatabaseAction {
    public static ResultSet query(String name, String nation, Integer minAge, Integer maxAge, Integer ability, String division) {
        String query = "SELECT * FROM PlayerAttributes WHERE Name LIKE ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Parametreyi ayarla
            // PARAMETRELERİN HEPSİNİ BURAYA ATINCA HATA VERİYOR. TEK STRİNG İSTİYOR.
            pstmt.setString(1, "%" + "" + "%");

            // Sorguyu çalıştır ve sonucu döndür
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        }
    }
    public static ArrayList<Player> search(String name, String nation, Integer minAge, Integer maxAge, Integer ability, String division) {
        ResultSet output = query(name, nation, minAge, maxAge, ability, division);
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
