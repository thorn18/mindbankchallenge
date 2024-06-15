package models;

import java.util.UUID;

/**
 * Vertex class which models a "Node" within a DAG.
 * @field privateID is is a unique identifier which is specific to that node, a DAG can not
 * more than one vertex with the same privateID. The ID will be 
 */
public class Vertex {

    private UUID vertexID;
    private Vertex parent;


    /**
     * Constructor of a "parent" Vertex;
     */
    public Vertex() {
        this.parent = null;
        UUID uuid = UUID.randomUUID();
        this.vertexID = uuid;
    }

    public Vertex(Vertex parent) {
        this.parent = parent;
        UUID uuid = UUID.randomUUID();
        this.vertexID = uuid;
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
    public UUID getID() {
        return vertexID;
    }

    @Override
    public String toString(){
        return this.getID().toString().substring(0, 8);
    }

}