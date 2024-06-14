package models;

import java.util.LinkedList;
import java.util.UUID;

/**
 * @feild parentNode is the "Parent" node, or the top of a DAG from which all edges originate.
 * @field edgeList is an ArrayList of edges that makes up the DAG;
 * @field nodeCount is the number of unique Nodes in a DAG;
 */
public class Dag {

    private LinkedList<Edge> edgeList;
    private int nodeCount;


    /**
     * Constructor for a premade set of edges that makes up the dag.
     * @param edges is the provided list of Edges to make the dag;
     */
    public Dag(LinkedList<Edge> edges) {
        for(Edge e : edges) {
            edgeList.add(e);
        }
        this.nodeCount = computeNodeCount(edgeList);
    }

    /*
     * Gets the number of vertex in a DAG;
     */
    public int getNodeCount() {
        return this.nodeCount;
    }

    /**
     * Computes the number of unique Vertex in a DAG.
     * @param edgeList2 the dag to be checked
     * @return the number of unique nodes in that DAG.
     */
    private int computeNodeCount(LinkedList<Edge> edgeList) {
        LinkedList<UUID> countlist = new LinkedList<>();
        for(Edge e: edgeList) {
            if(countlist.contains(e.getOriginator().getID())) {
                //Do nothing
            } else{
                countlist.add(e.getOriginator().getID());
            }
            if(countlist.contains(e.getReciever().getID())) {
                //Do nothing
            } else{
                countlist.add(e.getReciever().getID());
            }
        }
        return countlist.size();
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Edge e: edgeList) {
            sb.append("Edge - Vertex A: " + e.getOriginator().toString());
            sb.append("   Vertex B: " + e.getReciever().toString() + "/n");
        }
        return sb.toString();
    }
    
}
