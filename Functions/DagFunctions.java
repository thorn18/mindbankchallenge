package Functions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import models.Dag;
import models.Edge;
import models.Vertex;

public class DagFunctions {


    public int findLongestPath(Dag theDag) {
        // TODO
        return 0;
    }

    /**
     * Finds and returns a vertex within a Dag. String s must be of sufficient length (at least 7 recommended) that the
     * vertex found will be the unique one you look for.
     * @param dag The dag which is being searched.
     * @param s String which matches the UUID in the Dag.
     * @return A vertex which has a UUId which matches the UUID.
     * @throws Exception
     */
    public static Vertex findVertex(Dag dag, String s) throws Exception {
        System.out.println("Search String:" + s);
        Vertex ret = null;
        for(Edge e: dag.getEdgeList()) {
            //Checking if substring s (the id) is included in the Dag.
            System.out.println("Checking Against Originator:" + e.getOriginator().getID().toString().substring(0, s.length()));
            System.out.println("Checking Against Reciever:" + e.getReciever().getID().toString().substring(0, s.length()));
            if(e.getOriginator().getID().toString().substring(0, s.length()).equals(s)) {
                ret = e.getOriginator();
                break;
            } else if(e.getReciever().getID().toString().substring(0, s.length()).equals(s)) {
                ret = e.getReciever();
                break;
            } else{

            }
        }
        if(ret != null) {
            return ret;
        } else {
            throw new Exception("There was no Vertex with this string included");
        }
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

        ArrayList<Edge> dagFinal = new ArrayList<Edge>();
        LinkedList<Vertex> vertexList = new LinkedList<Vertex>();

        int sizeThis = size;
        Vertex parent = new Vertex();
        vertexList.add(parent);
        sizeThis = size - 1;
        Random random = new Random();

        while (sizeThis != 0) {
            int randomnode = random.nextInt(vertexList.size());
            Vertex newVertex = new Vertex(vertexList.get(randomnode));
            vertexList.add(newVertex);
            Edge newEdge = new Edge(vertexList.get(randomnode), newVertex);
            dagFinal.add(newEdge);
            sizeThis = sizeThis - 1;
        }

        Dag completeDag = new Dag(dagFinal);

        return completeDag;
    }

}
