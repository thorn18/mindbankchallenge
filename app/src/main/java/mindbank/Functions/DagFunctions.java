package mindbank.Functions;

import mindbank.models.Dag;
import mindbank.models.Edge;
import mindbank.models.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class DagFunctions {

    public static int findLongestPath(int nodeCount, List<List<Edge>> adjList, Stack<Long> topologcialOrder, long selectedVertex) {

        ArrayList<Integer> distances = new ArrayList<Integer>();
        //Initializing all distances to -Inf
        for(int x = 0; x < nodeCount; x++) {
            distances.add(Integer.MIN_VALUE);
        }
        distances.set(Integer.valueOf((int)selectedVertex), Integer.valueOf(0));

        System.out.println("Initialized Distance Minimum: ");
        System.out.println(distances.toString());


        while(!topologcialOrder.isEmpty()) {
            long vertex = topologcialOrder.pop();

            /**
             * checking if you have reached the vertex yet you are checking for.
             */
            if(distances.get((int) vertex) != Integer.MIN_VALUE) {

                for(int y= 0; y < adjList.size(); y++) {
                    //Checking if vertex has children
                    if(adjList.get(y).get(0).getOriginator().getID() == vertex) {
                        List<Edge> inner = adjList.get(y);
                        for(Edge e: inner) {
                            //Assigning Vertex V to the child.
                            Vertex v = e.getReciever();
                            int id = (int)v.getID();
                            if(distances.get(id) < distances.get((int)vertex)) {
                                distances.set(id, distances.get((int)vertex) + 1);
                            }
                        }
                    }

                }

            }

        }

        System.out.println("\n\nFinal Distance Array: ");
        int largestpath = 0;
        for(int l : distances) {
            largestpath = Math.max(largestpath, l);
            if(l == Integer.MIN_VALUE) {
                System.out.print("Not Reachable, ");
            } else {
                System.out.print(l + ", ");
            }
        }
        System.out.println("\n\nLongest Path is distance: " +largestpath);

        return largestpath;
    }

    /**
     * Finds and returns a vertex within a Dag. String s must be of sufficient
     * length (at least 7 recommended) that the
     * vertex found will be the unique one you look for.
     *
     * @param dag The dag which is being searched.
     * @param s   String which matches the UUID in the Dag.
     * @return A vertex which has a UUId which matches the UUID.
     * @throws Exception
     */
    public static Vertex findVertex(Dag dag, String s) throws Exception {
        System.out.println("Search String:" + s);
        Vertex ret = null;
        for (Edge e : dag.getEdgeList()) {
            // Checking if substring s (the id) is included in the Dag.
            System.out.println("Checking Against Originator:" + e.getOriginator().getID());
            System.out.println("Checking Against Reciever:" + e.getReciever().getID());
            if (e.getOriginator().getID() == Long.valueOf(s)) {
                ret = e.getOriginator();
                break;
            } else if (e.getReciever().getID() == Long.valueOf(s)) {
                ret = e.getReciever();
                break;
            } else {

            }
        }
        if (ret != null) {
            return ret;
        } else {
            throw new Exception("There was no Vertex with this string included");
        }
    }

    /**
     * Method which will Topologically sort our dag, returning an adjacency list
     * which we can use
     * for the longest path problem.
     *
     * @param dag the dag to be sorted
     * @return the
     */
    public static Stack<Long> topologicalSort(Dag dag) {
        List<List<Edge>> adjList = adjacencyUtil(dag.getEdgeList());

        System.out.println("Number of edges in DAG: " + adjList.size());
        for (List<Edge> adj : adjList) {
            System.out.println("\nChildren for node: " + adj.get(0).getOriginator().getID());
            for (Edge x : adj) {
                System.out.print(" - " + x.getReciever().getID());
            }
        }

        Stack<Long> sorted = new Stack<Long>();
        Stack<Long> check = new Stack<Long>();
        List<Long> visited = new ArrayList<Long>();

        for (List<Edge> adj : adjList) {
            sorted = topologicalUtil(dag.getEdgeList(), adj, visited, sorted);
        }

        return sorted;
    }

    /**
     * Utility method which is Recursivly building the sorted stack of visited nodes, in topological order.
     * @param edgeList The list of edges for the DAG
     * @param adjList The list of Adjacency edges that the algorithm is going to check.
     * @param visited The visited nodes, which won't be re-run.
     * @param sorted A copy of the sorted stack.
     * @return the sorted stack in topological order, containing the IDs of the Vertex
     */
    private static Stack<Long> topologicalUtil(ArrayList<Edge> edgeList, List<Edge> adjList, List<Long> visited,
                                               Stack<Long> sorted) {
        System.out.println("\n\n\n");
        System.out.println("Top of UTIL");
        System.out.println("Visited Array: " + visited);
        System.out.print("edgeList to check: ");
        for(Edge edgetemp : adjList) {
            System.out.print(" " + edgetemp.getOriginator().getID() + " - " + edgetemp.getReciever() + ",");
        }
        System.out.print("\n");
        List<Long> temp2List = new ArrayList<>();
        for (Edge edge : adjList) {
            System.out.println("Checking Edge: " + edge.getOriginator() + " - " + edge.getReciever());
            if (!visited.contains(edge.getReciever().getID())) {
                System.out.println("Checking Visited: FALSE!");
                if (checkHasChildren(edgeList, edge.getReciever().getID())) {
                    System.out.println("Checking Children: True!");
                    List<Edge> templist = new ArrayList<>();
                    for (Edge e : edgeList) {
                        // If a Vertex has children(Checked above), then it will create a new list of
                        // Edges that have that vertex as the originator.
                        if (e.getOriginator().getID() == edge.getReciever().getID()) {
                            templist.add(e);
                        }
                    }
                    //Recursive call on List of Edges belonging to the child.
                    topologicalUtil(edgeList, templist, visited, sorted);
                } else {
                    System.out.println("Checking Children: False!");
                    visited.add(edge.getReciever().getID());
                    sorted.push(edge.getReciever().getID());

                    List<Edge> templist = new ArrayList<>();
                    for (Edge e : edgeList) {
                        // If a Vertex has children(Checked above), then it will create a new list of
                        // Edges that have that vertex as the originator.
                        if (e.getOriginator().getID() == edge.getReciever().getID()) {
                            templist.add(e);
                        }
                    }
                    //If a node only has 1 parent, this will be called so that it adds the parent node to the adjacency list, since there is no more nodes to add, and
                    //the recursive method won't be called again for this node.
                    if(adjList.size() == 1) {
                        visited.add(adjList.get(0).getOriginator().getID());
                        sorted.add(adjList.get(0).getOriginator().getID());
                    }

                    System.out.print("Templist inside Else: ");
                    for(Edge e: templist) {
                        System.out.print(e.getReciever() + " ,");
                    }
                    System.out.println("\nvisited inside Else: " + visited);
                }
            } else {
                temp2List.add(edge.getReciever().getID());
                System.out.println("Visited: True!");
            }
        }
        if(visited.containsAll(temp2List) && !visited.contains(adjList.get(0).getOriginator().getID()) && !sorted.contains(adjList.get(0).getOriginator().getID())) {
            visited.add(adjList.get(0).getOriginator().getID());
            sorted.add(adjList.get(0).getOriginator().getID());
        }
        temp2List.clear();
        return sorted;
    }

    /**
     * Helper method which checks if a vertex has children;
     *
     * @param arrayList of edges in Dag.
     * @param l         the id of the vertex
     * @return whether or not it has children.
     */
    private static boolean checkHasChildren(ArrayList<Edge> arrayList, long l) {
        boolean ret = false;
        for (Edge e : arrayList) {
            if (e.getOriginator().getID() == l) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    /**
     * Method which creates an adjacency list for each Vertex, where each index in the resulting List is List of Edges for that vertex.
     * @param edges The list of edges for the DAG
     * @return The adjacency List
     */
    public static List<List<Edge>> adjacencyUtil(List<Edge> edges) {
        List<List<Edge>> adjList = new ArrayList<>();
        List<Long> visited = new ArrayList<>();

        for (Edge e : edges) {
            List<Edge> adjacencies = new ArrayList<>();
            long a = e.getOriginator().getID();
            if (!visited.contains(a)) {
                for (Edge e2 : edges) {
                    if (e2.getOriginator().getID() == a) {
                        adjacencies.add(e2);
                    }
                }
                visited.add(a);
                adjList.add(adjacencies);
            } else {
            }
        }
        return adjList;
    }

    /**
     * Method that creates a random dag of a certain size; The dag will be simple,
     * and while a node using this
     * method may have two children, it will never have two parents.
     *
     * @param size the number of Vertex in a DAG
     * @return the Dag of size x;
     */
    public static Dag createADag(int size) {
        int index = 1;

        ArrayList<Edge> dagFinal = new ArrayList<Edge>();
        LinkedList<Vertex> vertexList = new LinkedList<Vertex>();

        int sizeThis = size;
        Vertex parent = new Vertex();
        vertexList.add(parent);
        sizeThis = size - 1;
        Random random = new Random();

        while (sizeThis != 0) {
            int randomnode = random.nextInt(vertexList.size());
            Vertex newVertex = new Vertex(index, vertexList.get(randomnode));
            index += 1;
            vertexList.add(newVertex);
            Edge newEdge = new Edge(vertexList.get(randomnode), newVertex);
            dagFinal.add(newEdge);
            sizeThis = sizeThis - 1;
        }

        Dag completeDag = new Dag(dagFinal);

        return completeDag;
    }

}