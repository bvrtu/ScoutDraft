import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;
public class Main {

    public static void main(String args[])
    {
        /*Formation hasomango = new Formation();
        hasomango.setFormation_name("A4_3_1_2");
        // Object of graph is created.
        Formation.Graph<Integer> g = hasomango.create_graph();
        Player Hasan = new Player();
        Hasan.setName("Hasan Efe");
        Hasan.setAge(23);
        Hasan.setLeague("TSL");
        Hasan.setNation("Turkey");
        Hasan.setTeam_name("FB");
        Player Bartu = new Player();
        Bartu.setName("Bartu");
        Bartu.setAge(23);
        Bartu.setLeague("TSL");
        Bartu.setNation("Turkey");
        Bartu.setTeam_name("FB");
        Player[] biz = new Player[11];
        biz[0] = Hasan;
        biz[1] = Bartu;
        hasomango.setPlayers(biz);
        hasomango.checkLinks(0);*/

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        /*
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        // Printing the graph
        System.out.println("Graph:\n" + g.toString());

        // Gives the no of vertices in the graph.
        g.getVertexCount();

        // Gives the no of edges in the graph.
        g.getEdgesCount(true);

        // Tells whether the edge is present or not.
        g.hasEdge(3, 4);

        // Tells whether vertex is present or not
        g.hasVertex(5);
        g.neighbours(1);

         */
        // System.out.println("Graph:\n" + g.toString());
        /*ArrayList<Player> output = DatabaseAction.search("");
        for (Player p : output){
            System.out.println(p.toString());
        }
         */
        ArrayList<Player> output = DatabaseAction.query("Messi");
        for(Player p : output){
            System.out.println(p);
        }
        Gui gui = new Gui();

        gui.show();
    }
}
