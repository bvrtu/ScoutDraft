import java.util.*;
public class Formation {
    private String formation_name;
    public Graph create_graph(){
        Graph<Integer> the_graph = new Graph<Integer>();
        switch(this.formation_name){
            case "A3_4_3":
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
                break;
            case "A3_4_1_2":
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
                break;
            case "A3_4_2_1":
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
                break;
            case "A3_5_2":
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
                break;
            case "A4_1_2_1_2":
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
                break;
                case "A4_1_4_1":
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
                    break;
            case "A4_2_2_2":
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
                break;
            case "A4_2_3_1":
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
                break;
            case "A4_3_1_2":
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
                break;
            case "A4_3_2_1":
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
                break;
            case "A4_3_3":
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
                break;
            case "A4_4_1_1":
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
                break;
            case "A4_4_2":
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
                break;
            case "A4_5_1":
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
                break;
            case "A5_2_2_1":
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
                break;
            case "A5_2_1_2":
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
                break;
            case "A5_3_2":
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

        public void neighbours(T s)
        {
            if(!map.containsKey(s))
                return ;
            System.out.println("The neighbours of "+s+" are");
            for(T w:map.get(s))
                System.out.print(w+",");
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
