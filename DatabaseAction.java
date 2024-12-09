import java.sql.*;

public class DatabaseAction {
    public static ResultSet search(String word) {
        String quary = "SELECT * FROM PlayerAttributes WHERE NAME LIKE " + word + " % ;";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db")) {
            Statement stmt = conn.createStatement();
             ResultSet output = stmt.executeQuery(quary);
             return output;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
