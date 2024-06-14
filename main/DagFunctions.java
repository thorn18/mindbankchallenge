package main;

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
     * Method that creates a random dag of a certain size; The dag will be simple,
     * and while a node using this
     * method may have two children, it will never have two parents.
     * 
     * @param size the number of Vertex in a DAG
     * @return the Dag of size x;
     */
    public Dag createADag(int size) {

        LinkedList<Edge> dagFinal = new LinkedList<Edge>();
        LinkedList<Vertex> vertexList = new LinkedList<Vertex>();

        int sizeThis = size;
        Vertex parent = new Vertex();
        vertexList.add(parent);
        sizeThis = size - 1;
        Random random = new Random();

        while (sizeThis != 0) {
            int randomnode = random.nextInt(vertexList.size());
            Vertex newVertex = new Vertex(vertexList.get(randomnode));
            Edge newEdge = new Edge(vertexList.get(randomnode), newVertex);
            dagFinal.add(newEdge);
        }

        Dag completeDag = new Dag(dagFinal);

        return completeDag;
    }

}
