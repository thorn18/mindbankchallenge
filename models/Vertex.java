package models;

import java.util.UUID;

/**
 * Vertex class which models a "Node" within a DAG.
 * @field privateID is is a unique identifier which is specific to that node, a DAG can not
 * more than one vertex with the same privateID. The ID will be 
 */
class Vertex {

    private UUID vertexID;

    public Vertex() {
        UUID uuid = UUID.randomUUID();
        this.vertexID = uuid;
    }

    public UUID getID() {
        return vertexID;
    }

}