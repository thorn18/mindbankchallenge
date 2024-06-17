package mindbank;

import mindbank.Functions.DagFunctions;
import mindbank.models.Dag;
import mindbank.models.Edge;
import mindbank.models.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


/**
 * Topological sorting for a pre-made Dag for testing purposes.
 */
public class PremadeDagChallenge {

    static Dag d1;

    public static void main(String[] args) {

        Edge a = new Edge(new Vertex(0), new Vertex(2));
        Edge b = new Edge(new Vertex(0), new Vertex(3));
        Edge c = new Edge(new Vertex(1), new Vertex(3));
        Edge d = new Edge(new Vertex(1), new Vertex(4));
        Edge e = new Edge(new Vertex(3), new Vertex(5));
        Edge f = new Edge(new Vertex(3), new Vertex(6));
        Edge g = new Edge(new Vertex(6), new Vertex(8));
        Edge h = new Edge(new Vertex(7), new Vertex(8));
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(a);
        edges.add(b);
        edges.add(c);
        edges.add(d);
        edges.add(e);
        edges.add(f);
        edges.add(g);
        edges.add(h);

        Dag d1 = new Dag(edges);

        System.out.println(d1);
        System.out.println("Topologically sorting dag...");
        Stack<Long> sorted = DagFunctions.topologicalSort(d1);
        List<List<Edge>> adjList = DagFunctions.adjacencyUtil(d1.getEdgeList());
        System.out.println("Sorted Stack using topological sort");
        System.out.println(sorted);

        // Change last paramanter to whichever vertex you would like to start from.
        DagFunctions.findLongestPath(d1, adjList, sorted, 1);

    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
