import java.util.*;
public class Formation {
    private Player[] players = new Player[11];
    // We need to add uiToGraph and graphToUI because, the sorting in the ui and sorting in the system differs
    private HashMap<Integer, Integer> uiToGraph = new HashMap<Integer, Integer>();
    public HashMap<Integer, Integer> getUiToGraph(){
        return this.uiToGraph;
    }
    // There is no graphToUI because there is no need, we reverse uiToGraph and return it.
    public HashMap<Integer, Integer> getGraphToUI(){
        Map<Integer, Integer> graphToUI = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : uiToGraph.entrySet()) {
            graphToUI.put(entry.getValue(), entry.getKey());
        }
        return new HashMap(graphToUI);}
    private String formation_name;
    Graph<Integer> the_graph = new Graph<Integer>();
    public void create_graph(){
        //The creation of formations. This has to be done manually.
        switch(this.formation_name){
            case "3-4-3":
                // Store the edge data in an array
                int[][] edges1 = {
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 4},
                        {2, 3}, {2, 5}, {2, 6}, {3, 7}, {4, 8},
                        {4, 5}, {5, 6}, {5, 10}, {6, 7}, {6, 10},
                        {7, 9}, {8, 10}, {9, 10}
                };
                // Adding all edges to graph
                for (int[] edge : edges1) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                // Difference to UI
                int[][] mappings1 = {
                        {10, 0}, {9, 3}, {8, 2}, {7, 1}, {6, 7},
                        {5, 6}, {4, 5}, {3, 4}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] mapping : mappings1) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }
                break;
            case "3-4-1-2":
                int[][] edges2 = {
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 4},
                        {2, 3}, {2, 5}, {2, 6}, {3, 7}, {4, 8},
                        {4, 5}, {5, 6}, {5, 10}, {6, 7}, {6, 10},
                        {7, 9}, {8, 10}, {9, 10}, {8, 9}
                };
                for (int[] edge : edges2) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }

                int[][] mappings2 = {
                        {10, 0}, {9, 3}, {8, 2}, {7, 1}, {6, 7},
                        {5, 6}, {4, 5}, {3, 4}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] mapping : mappings2) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }

                break;
            case "3-4-2-1":
                int[][] edges3 = {
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 4},
                        {2, 3}, {2, 5}, {2, 6}, {3, 7}, {4, 8},
                        {4, 5}, {5, 6}, {5, 8}, {6, 7}, {6, 9},
                        {7, 9}, {8, 10}, {9, 10}
                };
                for (int[] edge : edges3) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }

                int[][] mappings3 = {
                        {10, 0}, {9, 3}, {8, 2}, {7, 1}, {6, 7},
                        {5, 6}, {4, 5}, {3, 4}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] mapping : mappings3) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }

                break;
            case "3-5-2":
                int[][] edges4 = {
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 4}, {1, 5},
                        {2, 3}, {2, 5}, {2, 6}, {3, 6}, {3, 7},
                        {4, 8}, {4, 5}, {5, 6}, {5, 10}, {6, 7},
                        {6, 10}, {7, 9}, {8, 10}, {9, 10}, {8, 9}
                };
                for (int[] edge : edges4) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings4 = {
                        {10, 0}, {9, 3}, {8, 2}, {7, 1}, {6, 7},
                        {5, 6}, {4, 5}, {3, 4}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] mapping : mappings4) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }
                break;
            case "4-1-2-1-2":
                int[][] edges5 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 6},
                        {2, 3}, {2, 6}, {3, 7}, {4, 5}, {5, 6},
                        {5, 8}, {5, 10}, {6, 7}, {6, 10}, {7, 9},
                        {7, 10}, {8, 9}, {8, 10}, {9, 10}
                };
                for (int[] edge : edges5) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings5 = {
                        {10, 0}, {9, 3}, {8, 6}, {7, 4}, {6, 7},
                        {5, 2}, {4, 1}, {3, 5}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] mapping : mappings5) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }

                break;
            case "4-1-4-1":
                int[][] edges6 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 6},
                        {2, 3}, {2, 6}, {3, 7}, {4, 5}, {5, 8},
                        {5, 9}, {6, 8}, {6, 10}, {7, 9}, {7, 10},
                        {8, 9}, {8, 10}, {9, 10}
                };
                for (int[] edge : edges6) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings6 = {
                        {10, 0}, {9, 3}, {8, 6}, {7, 4}, {6, 7},
                        {5, 2}, {4, 1}, {3, 5}, {2, 10}, {1, 8}, {0, 9}
                };
                for (int[] mapping : mappings6) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }

                break;
            case "4-2-2-2":
                int[][] edges7 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 8},
                        {2, 3}, {2, 6}, {3, 7}, {4, 5}, {5, 8},
                        {5, 10}, {6, 7}, {6, 8}, {6, 9}, {7, 9},
                        {8, 10}, {9, 10}
                };
                for (int[] edge : edges7) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings7 = {
                        {10, 0}, {9, 3}, {8, 8}, {7, 4}, {6, 7},
                        {5, 2}, {4, 1}, {3, 5}, {2, 6}, {1, 9}, {0, 10}
                };
                for (int[] mapping : mappings7) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }

                break;
            case "4-2-3-1":
                int[][] edges8 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 8},
                        {2, 3}, {2, 6}, {3, 6}, {4, 8}, {5, 8},
                        {5, 9}, {5, 10}, {6, 7}, {6, 8}, {6, 10},
                        {7, 9}, {7, 10}, {8, 10}, {9, 10}
                };
                for (int[] edge : edges8) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings8 = {
                        {10, 0}, {9, 6}, {8, 10}, {7, 8}, {6, 3},
                        {5, 2}, {4, 1}, {3, 4}, {2, 7}, {1, 5}, {0, 9}
                };
                for (int[] mapping : mappings8) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }
                break;
            case "4-3-1-2":
                int[][] edges9 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {2, 3},
                        {1, 5}, {1, 6}, {2, 6}, {2, 7}, {3, 7},
                        {4, 5}, {5, 6}, {5, 8}, {6, 7}, {6, 10},
                        {7, 9}, {8, 9}, {8, 10}, {9, 10}
                };
                for (int[] edge : edges9) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings9 = {
                        {10, 0}, {9, 7}, {8, 6}, {7, 5}, {6, 3},
                        {5, 2}, {4, 1}, {3, 4}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] mapping : mappings9) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }
                break;
            case "4-3-2-1":
                int[][] edges10 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 5},
                        {2, 3}, {2, 7}, {3, 7}, {4, 5}, {5, 6},
                        {5, 8}, {6, 7}, {6, 8}, {6, 9}, {7, 9},
                        {8, 10}, {9, 10}
                };
                for (int[] edge : edges10) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings10 = {
                        {10, 0}, {9, 7}, {8, 6}, {7, 5}, {6, 3},
                        {5, 2}, {4, 1}, {3, 4}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] mapping : mappings10) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }

                break;
            case "4-3-3":
                int[][] edges11 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 6},
                        {2, 3}, {2, 6}, {3, 7}, {4, 5}, {5, 6},
                        {5, 8}, {6, 7}, {6, 10}, {7, 9}, {8, 10},
                        {9, 10}
                };
                for (int[] edge : edges11) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings11 = {
                        {10, 0}, {9, 7}, {8, 6}, {7, 5}, {6, 3},
                        {5, 2}, {4, 1}, {3, 4}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] mapping : mappings11) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }

                break;
            case "4-4-1-1":
                int[][] edges12 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 6},
                        {2, 3}, {2, 8}, {3, 7}, {4, 5}, {5, 6},
                        {5, 9}, {6, 8}, {6, 10}, {7, 8}, {7, 9},
                        {8, 10}, {9, 10}
                };
                for (int[] edge : edges12) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings12 = {
                        {10, 0}, {9, 8}, {8, 10}, {7, 6}, {6, 3},
                        {5, 2}, {4, 1}, {3, 4}, {2, 7}, {1, 5}, {0, 9}
                };
                for (int[] mapping : mappings12) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }
                break;
            case "4-4-2":
                int[][] edges13 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 6},
                        {2, 3}, {2, 8}, {3, 7}, {4, 5}, {5, 6},
                        {5, 10}, {6, 8}, {6, 10}, {7, 8}, {7, 9},
                        {8, 9}, {9, 10}
                };
                for (int[] edge : edges13) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] mappings13 = {
                        {10, 0}, {9, 8}, {8, 10}, {7, 6}, {6, 3},
                        {5, 2}, {4, 1}, {3, 4}, {2, 7}, {1, 5}, {0, 9}
                };
                for (int[] mapping : mappings13) {
                    uiToGraph.put(mapping[0], mapping[1]);
                }
                break;
            case "4-5-1":
                int[][] edges14 = {
                        {0, 1}, {0, 2}, {1, 2}, {1, 4}, {1, 6},
                        {2, 3}, {2, 6}, {3, 7}, {4, 5}, {5, 8},
                        {6, 8}, {6, 10}, {7, 10}, {8, 9}, {8, 10}, {9, 10}
                };
                for (int[] edge : edges14) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] pairs14 = {
                        {10, 0}, {9, 10}, {8, 6}, {7, 8}, {6, 3},
                        {5, 2}, {4, 1}, {3, 4}, {2, 7}, {1, 5}, {0, 9}
                };
                for (int[] pair : pairs14) {
                    uiToGraph.put(pair[0], pair[1]);
                }
                break;
            case "5-2-2-1":
                int[][] edges15 = {
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 4}, {2, 3}, {2, 5}, {2, 6},
                        {3, 7}, {4, 8}, {4, 5}, {5, 6}, {5, 8}, {5, 10}, {6, 7}, {6, 9},
                        {6, 10}, {7, 9}, {8, 10}, {9, 10}
                };
                for (int[] edge : edges15) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] pairs15 = {
                        {10, 0}, {9, 3}, {8, 2}, {7, 1}, {6, 7}, {5, 6}, {4, 5}, {3, 4},
                        {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] pair : pairs15) {
                    uiToGraph.put(pair[0], pair[1]);
                }
                break;
            case "5-2-1-2":
                int[][] edges16 = {
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 4},
                        {2, 3}, {2, 5}, {2, 6}, {3, 7}, {4, 5},
                        {5, 6}, {5, 10}, {5, 8}, {6, 7}, {6, 9},
                        {6, 10}, {8, 10}, {9, 10}, {8, 9}
                };
                for (int[] edge : edges16) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] uiToGraphData16 = {
                        {10, 0}, {9, 3}, {8, 2}, {7, 1}, {6, 7},
                        {5, 6}, {4, 5}, {3, 4}, {2, 9}, {1, 8}, {0, 10}
                };
                for (int[] pair : uiToGraphData16) {
                    uiToGraph.put(pair[0], pair[1]);
                }
                break;
            case "5-3-2":
                int[][] edges17 = {
                        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 8},
                        {3, 6}, {3, 7}, {4, 5}, {5, 8}, {5, 10}, {6, 7}, {6, 8}, {6, 9},
                        {8, 9}, {8, 10}, {9, 10}
                };
                for (int[] edge : edges17) {
                    the_graph.addEdge(edge[0], edge[1], true);
                }
                int[][] uiToGraphData17 = {
                        {10, 0}, {9, 3}, {8, 2}, {7, 1}, {6, 7},
                        {5, 6}, {4, 5}, {3, 4}, {2, 9}, {1, 10}, {0, 18}
                };
                for (int[] pair : uiToGraphData17) {
                    uiToGraph.put(pair[0], pair[1]);
                }
                break;
        }
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
        // This method allows us to check the vertex's connected vertexes and rank the link between them.
        // This creates a list that stores links.
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
        // Links has the vertexes and a rank
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