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
            var stmt = conn.createStatement();
            var create = "CREATE TABLE IF NOT EXISTS PlayerAttributes(" +
                    "    ID INT PRIMARY KEY," +
                    "    Name VARCHAR(255)," +
                    "    Club VARCHAR(255)," +
                    "    CA INT," +
                    "    Age INT," +
                    "    Height DECIMAL(5, 2)," +
                    "    Nati VARCHAR(50)," +
                    "    Preferred_Foot VARCHAR(10)," +
                    "    Position VARCHAR(50)," +
                    "    Transfer_Value VARCHAR(50)," +
                    "    Agg INT," +
                    "    TRO INT," +
                    "    One_v_One INT," +
                    "    Fin INT," +
                    "    Bra INT," +
                    "    Wor INT," +
                    "    Agi INT," +
                    "    Sta INT," +
                    "    Kic INT," +
                    "    Bal INT," +
                    "    Dri INT," +
                    "    Han INT," +
                    "    Thr INT," +
                    "    Str INT," +
                    "    Aer INT," +
                    "    Pac INT," +
                    "    Acc INT," +
                    "    Fir INT," +
                    "    Hea INT," +
                    "    Dec INT," +
                    "    Det INT," +
                    "    Cnt INT," +
                    "    Cor INT," +
                    "    Ldr INT," +
                    "    Mar INT," +
                    "    Cro INT," +
                    "    Ant INT," +
                    "    Fla INT," +
                    "    Pas INT," +
                    "    Pen INT," +
                    "    Pos INT," +
                    "    Ref INT," +
                    "    Fre INT," +
                    "    Cmp INT," +
                    "    Tea INT," +
                    "    Tec INT," +
                    "    Tck INT," +
                    "    OtB INT," +
                    "    Lon INT," +
                    "    Vis INT," +
                    "    Nat INT," +
                    "    Pun INT," +
                    "    Jum INT," +
                    "    Division VARCHAR(255)" +
                    ");";
            stmt.execute(create);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void insertPlayer(int id, String name, String club, int ca, int age, String height, String nati,
                                    String preferredFoot, String position, String transferValue, int agg, int tro,
                                    int oneVOne, int fin, int bra, int wor, int agi, int sta, int kic, int bal, int dri,
                                    int han, int thr, int str, int aer, int pac, int acc, int fir, int hea, int dec,
                                    int det, int cnt, int cor, int ldr, int mar, int cro, int ant, int fla, int pas,
                                    int pen, int pos, int ref, int fre, int cmp, int tea, int tec, int tck, int otb,
                                    int lon, int vis, int nat, int pun, int jum, String division) {
        String insertSQL = """
                INSERT INTO PlayerAttributes (
                    ID, Name, Club, CA, Age, Height, Nati, Preferred_Foot, Position, Transfer_Value,
                    Agg, TRO, One_v_One, Fin, Bra, Wor, Agi, Sta, Kic, Bal, Dri, Han, Thr, Str, Aer,
                    Pac, Acc, Fir, Hea, Dec, Det, Cnt, Cor, Ldr, Mar, Cro, Ant, Fla, Pas, Pen, Pos,
                    Ref, Fre, Cmp, Tea, Tec, Tck, OtB, Lon, Vis, Nat, Pun, Jum, Division
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, club);
            pstmt.setInt(4, ca);
            pstmt.setInt(5, age);
            pstmt.setInt(6, Integer.parseInt(height.split(" ")[0]));
            pstmt.setString(7, nati);
            pstmt.setString(8, preferredFoot);
            pstmt.setString(9, position);
            pstmt.setString(10, transferValue);
            pstmt.setInt(11, agg);
            pstmt.setInt(12, tro);
            pstmt.setInt(13, oneVOne);
            pstmt.setInt(14, fin);
            pstmt.setInt(15, bra);
            pstmt.setInt(16, wor);
            pstmt.setInt(17, agi);
            pstmt.setInt(18, sta);
            pstmt.setInt(19, kic);
            pstmt.setInt(20, bal);
            pstmt.setInt(21, dri);
            pstmt.setInt(22, han);
            pstmt.setInt(23, thr);
            pstmt.setInt(24, str);
            pstmt.setInt(25, aer);
            pstmt.setInt(26, pac);
            pstmt.setInt(27, acc);
            pstmt.setInt(28, fir);
            pstmt.setInt(29, hea);
            pstmt.setInt(30, dec);
            pstmt.setInt(31, det);
            pstmt.setInt(32, cnt);
            pstmt.setInt(33, cor);
            pstmt.setInt(34, ldr);
            pstmt.setInt(35, mar);
            pstmt.setInt(36, cro);
            pstmt.setInt(37, ant);
            pstmt.setInt(38, fla);
            pstmt.setInt(39, pas);
            pstmt.setInt(40, pen);
            pstmt.setInt(41, pos);
            pstmt.setInt(42, ref);
            pstmt.setInt(43, fre);
            pstmt.setInt(44, cmp);
            pstmt.setInt(45, tea);
            pstmt.setInt(46, tec);
            pstmt.setInt(47, tck);
            pstmt.setInt(48, otb);
            pstmt.setInt(49, lon);
            pstmt.setInt(50, vis);
            pstmt.setInt(51, nat);
            pstmt.setInt(52, pun);
            pstmt.setInt(53, jum);
            pstmt.setString(54, division);

            pstmt.executeUpdate();
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
                    Integer.parseInt(cols[4]),cols[5],cols[6],cols[7],cols[8],cols[9]
                    ,Integer.parseInt(cols[10]),Integer.parseInt(cols[11]),Integer.parseInt(cols[12]),
                    Integer.parseInt(cols[13]),Integer.parseInt(cols[14]),Integer.parseInt(cols[15]),
                    Integer.parseInt(cols[16]),Integer.parseInt(cols[17]),Integer.parseInt(cols[18]),
                    Integer.parseInt(cols[19]),Integer.parseInt(cols[20]),Integer.parseInt(cols[21]),
                    Integer.parseInt(cols[22]),Integer.parseInt(cols[23]),Integer.parseInt(cols[24]),
                    Integer.parseInt(cols[25]),Integer.parseInt(cols[26]),Integer.parseInt(cols[27]),
                    Integer.parseInt(cols[28]), Integer.parseInt(cols[29]), Integer.parseInt(cols[30]),
                    Integer.parseInt(cols[31]), Integer.parseInt(cols[32]), Integer.parseInt(cols[33]),
                    Integer.parseInt(cols[34]), Integer.parseInt(cols[35]), Integer.parseInt(cols[36]),
                    Integer.parseInt(cols[37]), Integer.parseInt(cols[38]), Integer.parseInt(cols[39]),
                    Integer.parseInt(cols[40]), Integer.parseInt(cols[41]), Integer.parseInt(cols[42]),
                    Integer.parseInt(cols[43]), Integer.parseInt(cols[44]), Integer.parseInt(cols[45]),
                    Integer.parseInt(cols[46]), Integer.parseInt(cols[47]), Integer.parseInt(cols[48]),
                    Integer.parseInt(cols[49]), Integer.parseInt(cols[50]), Integer.parseInt(cols[51]),
                    Integer.parseInt(cols[52]),cols[53]);
        }
        sc.close();
    }
}