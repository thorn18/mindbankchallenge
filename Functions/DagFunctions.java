package Functions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import models.Dag;
import models.Edge;
import models.Vertex;

public class DagFunctions {

    public int findLongestPath(Dag theDag) {
        // TODO
        return 0;
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
     * Method which will Topologically sort our dag, returning an adjacency list which we can use
     * for the longest path problem.
     * @param dag the dag to be sorted
     * @return the
     */
    public Stack<Long> topologicalSort(Dag dag) {
        List<Edge> edges = dag.getEdgeList();
        // List<Long> vertexesIds = new ArrayList<>();
        // for(Edge e: edges) {
        //     if(!vertexesIds.contains(e.getOriginator().getID())) {
        //         vertexesIds.add(e.getOriginator().getID());
        //     }
        //     if(!vertexesIds.contains(e.getReciever().getID())) {
        //         vertexesIds.add(e.getReciever().getID());
        //     }
        // }

        Stack<Long> adjList = new Stack<Long>();
        List<Long> visited = new ArrayList<Long>();
        int size=  dag.getNodeCount();
        while(visited.size() != size) {
            
        }

        return adjList;
    }

    public List<List<Edge>> adjacencyUtil(List<Edge> edges) {
        List<List<Edge>> adjList = new ArrayList<>();
        List<Edge> adjacencies = new ArrayList<>();
        for(Edge e: edges) {
            long a = e.getOriginator().getID();
            for(Edge e2: edges) {
                adjacencies = new ArrayList<>();
                if(e2.getOriginator().getID() == a) {
                    adjacencies.add(e2);
                }
            }
            adjList.add(adjacencies);
            adjacencies.clear();
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
