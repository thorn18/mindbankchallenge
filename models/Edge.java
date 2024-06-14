package models;

import java.util.UUID;

/**
 * 
 * @field originator is the first Vertex in the edge, also the "Sending" vertex from which the path originates.
 * @field reciever is the second Vertex in the edge, also the "Recieving" vertex.
 */
public class Edge {
    private Vertex originator;
    private Vertex reciever;
    private UUID edgeID;

    /**
     * Constructor for an edge, recieving two vertex.
     */
    public Edge(Vertex nodea, Vertex nodeb) {
        this.originator = nodea;
        this.reciever = nodeb;
        UUID uuid = UUID.randomUUID();
        this.edgeID = uuid;
    }

    /**
     * Get method for originating Vertex
     * @return the vertex which is the originating "Node" in the edge.
     */
    public Vertex getOriginator() {
        return this.originator;
    }

    /**
     * Get method for recieveing Vertex
     * @return the vertex which is the recieveing "Node" in the edge.
     */
    public Vertex getReciever() {
        return this.reciever;
    }
}
