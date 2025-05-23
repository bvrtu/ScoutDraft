import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class Connect {
    /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:database.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
    public static void create_table() {
        try{
            var conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            // Get the connection to database
            var stmt = conn.createStatement();
            var create = "CREATE TABLE IF NOT EXISTS PlayerAttributes(" +
                    "    ID INT PRIMARY KEY," +
                    "    Name VARCHAR(255)," +
                    "    Club VARCHAR(255)," +
                    "    CA INT," +
                    "    Age INT," +
                    "    Nati VARCHAR(50)," +
                    "    Position VARCHAR(50)," +
                    "    Division VARCHAR(255)" +
                    ");";
            //The SQL code for creating table
            stmt.execute(create);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void insertPlayer(int id, String name, String club, int ca, int age, String nati,
                                    String position, String division) {
        String insertSQL = """
                INSERT INTO PlayerAttributes (
                    ID, Name, Club, CA, Age, Nati, Position, Division
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                """; // Insertion SQL code
        // The question marks will be filled after

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, club);
            pstmt.setInt(4, ca);
            pstmt.setInt(5, age);
            pstmt.setString(6, nati);
            pstmt.setString(7, position);
            pstmt.setString(8, division);
            // Filling the question marks
            pstmt.executeUpdate();
            // Saving the changes
            System.out.println("Player data inserted successfully.");

        } catch (Exception e) {
            System.out.println("Error inserting player data: " + e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        connect();
        create_table();
        Scanner sc = new Scanner(new File("fm24eng.csv"));

        sc.nextLine();
        while(sc.hasNextLine()){
            String row = sc.nextLine();
            String[] cols = row.split(";");
            insertPlayer(Integer.parseInt(cols[0]),cols[1],cols[2],Integer.parseInt(cols[3]),
                    Integer.parseInt(cols[4]),cols[5],cols[6],cols[7]);
        }
        // In the loop, scanner reads every line except first line, then splits when an ";" occurs
        // After that, inserts data to the table
        sc.close();
    }
}