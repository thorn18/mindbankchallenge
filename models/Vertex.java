package models;

import java.util.UUID;

/**
 * Vertex class which models a "Node" within a DAG.
 * @field privateID is is a unique identifier which is specific to that node, a DAG can not
 * more than one vertex with the same privateID. The ID will be 
 */
public class Vertex {

    private long vertexID;
    private Vertex parent;


    /**
     * Constructor of a DAG "parent" Vertex;
     */
    public Vertex() {
        this.parent = null;
        this.vertexID = 0;
    }

    /*
     * constuctor for child Vertex
     */
    public Vertex(long id, Vertex parent) {
        this.parent = parent;
        this.vertexID = id;
    }

      /*
     * constuctor for child Vertex
     */
    public Vertex(long id) {
        this.parent = null;
        this.vertexID = id;
    }

    /**
     * 
     * @return the parent of Vertex ("if it is not an originator vertex")
     */
    public Vertex getParent() {
        return this.parent;
    }

    /*
     * get's the unique id of the vertex
     */
    public long getID() {
        return vertexID;
    }

    @Override
    public String toString(){
        return String.valueOf(this.vertexID);
    }

}