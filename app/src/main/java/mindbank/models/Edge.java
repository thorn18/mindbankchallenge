package mindbank.models;

import java.util.UUID;
/**
 * 
 * @field originator is the first Vertex in the edge, also the "Sending" vertex from which the path originates.
 * @field reciever is the second Vertex in the edge, also the "Recieving" vertex.
 */
public class Edge {
    Vertex v = new Vertex();
    private final Vertex originator;
    private final Vertex reciever;
    private final UUID edgeID;

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
     * Returns a unique ID for an edge.
     * @return
     */
    public UUID getEdgeID() {
        return edgeID;
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
