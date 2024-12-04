import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.sql.Statement;
import java.util.ArrayList;
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
            var stmt = conn.createStatement();
            var create = "CREATE TABLE IF NOT EXISTS (" +
                    "id INTEGER PRIMARY KEY," +
                    "Name NOT NULL," +
                    "Club NOT NULL," +
                    "CA INTEGER," +
                    "Height INTEGER," +
                    "Nation NOT NULL," +
                    "Foot NOT NULL," +
                    "";
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        connect();

      /*  Scanner sc = new Scanner(new File("fm24eng.csv"));
        ArrayList<?> collumn = new ArrayList<>();
        for(int i = 1;sc.hasNextLine();i++){
            String row = sc.nextLine();
            for(String j: row.split(";")){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
       */
    }
}