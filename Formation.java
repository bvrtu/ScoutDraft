import java.util.*;
public class Formation {
    private Player[] players = new Player[11];
    private HashMap<Integer, Integer> uiToGraph = new HashMap<Integer, Integer>();
    public HashMap<Integer, Integer> getUiToGraph(){
        return this.uiToGraph;
    }
    private String formation_name;
    Graph<Integer> the_graph = new Graph<Integer>();
    public Graph create_graph(){
        switch(this.formation_name){
            case "3-4-3":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(0,3,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,5,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,8,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,2);
                uiToGraph.put(7,1);
                uiToGraph.put(6,7);
                uiToGraph.put(5,6);
                uiToGraph.put(4,5);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "3-4-1-2":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(0,3,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,5,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,8,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);
                the_graph.addEdge(8,9,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,2);
                uiToGraph.put(7,1);
                uiToGraph.put(6,7);
                uiToGraph.put(5,6);
                uiToGraph.put(4,5);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "3-4-2-1":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(0,3,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,5,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,8,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,9,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,2);
                uiToGraph.put(7,1);
                uiToGraph.put(6,7);
                uiToGraph.put(5,6);
                uiToGraph.put(4,5);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "3-5-2":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(0,3,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,5,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,5,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,8,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);
                the_graph.addEdge(8,9,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,2);
                uiToGraph.put(7,1);
                uiToGraph.put(6,7);
                uiToGraph.put(5,6);
                uiToGraph.put(4,5);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "4-1-2-1-2":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,6,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(7,10,true);
                the_graph.addEdge(8,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,6);
                uiToGraph.put(7,4);
                uiToGraph.put(6,7);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,5);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "4-1-4-1":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,6,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(5,9,true);
                the_graph.addEdge(6,8,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(7,10,true);
                the_graph.addEdge(8,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,6);
                uiToGraph.put(7,4);
                uiToGraph.put(6,7);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,5);
                uiToGraph.put(2,10);
                uiToGraph.put(1,8);
                uiToGraph.put(0,9);

                break;
            case "4-2-2-2":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,8,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,8,true);
                the_graph.addEdge(6,9,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,8);
                uiToGraph.put(7,4);
                uiToGraph.put(6,7);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,5);
                uiToGraph.put(2,6);
                uiToGraph.put(1,9);
                uiToGraph.put(0,10);

                break;
            case "4-2-3-1":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,8,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,6,true);
                the_graph.addEdge(4,8,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(5,9,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,8,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(7,10,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,6);
                uiToGraph.put(8,10);
                uiToGraph.put(7,8);
                uiToGraph.put(6,3);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,4);
                uiToGraph.put(2,7);
                uiToGraph.put(1,5);
                uiToGraph.put(0,9);

                break;
            case "4-3-1-2":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(1,5,true);
                the_graph.addEdge(1,6,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(2,7,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,7);
                uiToGraph.put(8,6);
                uiToGraph.put(7,5);
                uiToGraph.put(6,3);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "4-3-2-1":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,5,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,7,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,8,true);
                the_graph.addEdge(6,9,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,7);
                uiToGraph.put(8,6);
                uiToGraph.put(7,5);
                uiToGraph.put(6,3);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "4-3-3":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,6,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,7);
                uiToGraph.put(8,6);
                uiToGraph.put(7,5);
                uiToGraph.put(6,3);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "4-4-1-1":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,6,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,8,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,9,true);
                the_graph.addEdge(6,8,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,8,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,8);
                uiToGraph.put(8,10);
                uiToGraph.put(7,6);
                uiToGraph.put(6,3);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,4);
                uiToGraph.put(2,7);
                uiToGraph.put(1,5);
                uiToGraph.put(0,9);

                break;
            case "4-4-2":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,6,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,8,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,8,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,8,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,9,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,8);
                uiToGraph.put(8,10);
                uiToGraph.put(7,6);
                uiToGraph.put(6,3);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,4);
                uiToGraph.put(2,7);
                uiToGraph.put(1,5);
                uiToGraph.put(0,9);

                break;
            case "4-5-1":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,6,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(6,8,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,10,true);
                the_graph.addEdge(8,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,10);
                uiToGraph.put(8,6);
                uiToGraph.put(7,8);
                uiToGraph.put(6,3);
                uiToGraph.put(5,2);
                uiToGraph.put(4,1);
                uiToGraph.put(3,4);
                uiToGraph.put(2,7);
                uiToGraph.put(1,5);
                uiToGraph.put(0,9);

                break;
            case "5-2-2-1":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(0,3,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,5,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,8,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,9,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(7,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,2);
                uiToGraph.put(7,1);
                uiToGraph.put(6,7);
                uiToGraph.put(5,6);
                uiToGraph.put(4,5);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "5-2-1-2":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(0,3,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,5,true);
                the_graph.addEdge(2,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,6,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,9,true);
                the_graph.addEdge(6,10,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);
                the_graph.addEdge(8,9,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,2);
                uiToGraph.put(7,1);
                uiToGraph.put(6,7);
                uiToGraph.put(5,6);
                uiToGraph.put(4,5);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,8);
                uiToGraph.put(0,10);

                break;
            case "5-3-2":
                the_graph.addEdge(0,1,true);
                the_graph.addEdge(0,2,true);
                the_graph.addEdge(0,3,true);
                the_graph.addEdge(1,2,true);
                the_graph.addEdge(1,4,true);
                the_graph.addEdge(1,5,true);
                the_graph.addEdge(2,3,true);
                the_graph.addEdge(2,8,true);
                the_graph.addEdge(3,6,true);
                the_graph.addEdge(3,7,true);
                the_graph.addEdge(4,5,true);
                the_graph.addEdge(5,8,true);
                the_graph.addEdge(5,10,true);
                the_graph.addEdge(6,7,true);
                the_graph.addEdge(6,8,true);
                the_graph.addEdge(6,9,true);
                the_graph.addEdge(8,9,true);
                the_graph.addEdge(8,10,true);
                the_graph.addEdge(9,10,true);

                uiToGraph.put(10,0);
                uiToGraph.put(9,3);
                uiToGraph.put(8,2);
                uiToGraph.put(7,1);
                uiToGraph.put(6,7);
                uiToGraph.put(5,6);
                uiToGraph.put(4,5);
                uiToGraph.put(3,4);
                uiToGraph.put(2,9);
                uiToGraph.put(1,10);
                uiToGraph.put(0,8);

                break;

        }
        return the_graph;
    }
    public String getFormation_name() {
        return formation_name;
    }

    public void setFormation_name(String formation_name) {
        this.formation_name = formation_name;
    }
    public Player[] getPlayers() {
        return players;
    }
    public void setPlayers(Player[] players) {
        this.players = players;
    }
    public void addPlayer(Player player, int index) {
        players[uiToGraph.get(index)] = player;
    }
    public  ArrayList<Link> checkLinks(int index){
        index = uiToGraph.get(index);
        ArrayList<Link> links = new ArrayList<>();
        if(players[index]== null) System.out.println("The position is empty.");
        else if(the_graph.neighbours(index).isEmpty()) System.out.println("Neighbours are empty.");
         else {
             for(int i :the_graph.neighbours(index)){
                 if(players[i] == null) continue;
                 int rank = 0;
                if(Objects.equals(players[index].getLeague(), players[i].getLeague())) rank++;
                if(Objects.equals(players[index].getNation(), players[i].getNation())) rank++;
                if(Objects.equals(players[index].getTeam_name(), players[i].getTeam_name())) rank++;
                System.out.println(players[index].getName() + "has link rank " + String.valueOf(rank)
                 + "with" + players[i].getName() + ".");
                links.add(new Link(rank,index,i));

            }
         }
         return links;
    }
    public class Link{
        public Link(int rank, int vertex1, int vertex2){
            this.rank = rank;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
        int rank;
        int vertex1;
        int vertex2;
    }
    static class Graph<T> {

        // We use Hashmap to store the edges in the graph
        private Map<T, List<T> > map = new HashMap<>();

        // This function adds a new vertex to the graph
        public void addVertex(T s)
        {
            map.put(s, new LinkedList<T>());
        }
        // This function adds the edge
        // between source to destination
        public void addEdge(T source, T destination,
                            boolean bidirectional)
        {

            if (!map.containsKey(source))
                addVertex(source);

            if (!map.containsKey(destination))
                addVertex(destination);

            map.get(source).add(destination);
            if (bidirectional) {
                map.get(destination).add(source);
            }
        }
        // This function gives the count of vertices
        public void getVertexCount()
        {
            System.out.println("The graph has "
                    + map.keySet().size()
                    + " vertex");
        }

        // This function gives the count of edges
        public void getEdgesCount(boolean bidirection)
        {
            int count = 0;
            for (T v : map.keySet()) {
                count += map.get(v).size();
            }
            if (bidirection) {
                count = count / 2;
            }
            System.out.println("The graph has " + count
                    + " edges.");
        }

        // This function gives whether
        // a vertex is present or not.
        public void hasVertex(T s)
        {
            if (map.containsKey(s)) {
                System.out.println("The graph contains " + s
                        + " as a vertex.");
            }
            else {
                System.out.println("The graph does not contain "
                        + s + " as a vertex.");
            }
        }

        // This function gives whether an edge is present or
        // not.
        public void hasEdge(T s, T d)
        {
            if (map.get(s).contains(d)) {
                System.out.println(
                        "The graph has an edge between " + s
                                + " and " + d + ".");
            }
            else {
                System.out.println(
                        "The graph has no edge between " + s
                                + " and " + d + ".");
            }
        }

        public ArrayList<T> neighbours(T s)
        {
            if(!map.containsKey(s))
                return null;
            ArrayList<T> neighbours = new ArrayList<>();
            for(T w:map.get(s))
                neighbours.add(w);
            return neighbours;
        }

        // Prints the adjancency list of each vertex.
        @Override public String toString()
        {
            StringBuilder builder = new StringBuilder();

            for (T v : map.keySet()) {
                builder.append(v.toString() + ": ");
                for (T w : map.get(v)) {
                    builder.append(w.toString() + " ");
                }
                builder.append("\n");
            }

            return (builder.toString());
        }
    }

    // Driver Code

}
