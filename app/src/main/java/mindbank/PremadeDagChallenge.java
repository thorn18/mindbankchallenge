package mindbank;

import mindbank.Functions.DagFunctions;
import mindbank.models.Dag;
import mindbank.models.Edge;
import mindbank.models.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Longest Path for a pre-made Dag.
 */
public class PremadeDagChallenge {

    static Dag d1;

    public static void main(String[] args) {

        /*
         EDIT THIS VARIABLE for whichever DAG you wish to run the program on. Valid options are 1, 2 or 3
          See PremadeDags.PNG to see options.
         */
        int DAGSELECTION = 0;

        Dag d1 = null;


        if(DAGSELECTION == 0) {
            Edge a = new Edge(new Vertex(0), new Vertex(8));
            Edge b = new Edge(new Vertex(1), new Vertex(8));
            Edge c = new Edge(new Vertex(2), new Vertex(8));
            Edge d = new Edge(new Vertex(3), new Vertex(8));
            Edge e = new Edge(new Vertex(4), new Vertex(8));
            Edge f = new Edge(new Vertex(5), new Vertex(8));
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

            d1 = new Dag(edges);
        }

        if(DAGSELECTION == 1) {
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

            d1 = new Dag(edges);
        }

        if(DAGSELECTION == 2) {
            Edge a = new Edge(new Vertex(0), new Vertex(1));
            Edge b = new Edge(new Vertex(0), new Vertex(2));
            Edge c = new Edge(new Vertex(0), new Vertex(3));
            Edge d = new Edge(new Vertex(1), new Vertex(5));
            Edge e = new Edge(new Vertex(2), new Vertex(4));
            Edge f = new Edge(new Vertex(2), new Vertex(6));
            Edge g = new Edge(new Vertex(3), new Vertex(5));
            Edge h = new Edge(new Vertex(4), new Vertex(7));
            Edge i = new Edge(new Vertex(5), new Vertex(7));
            Edge j = new Edge(new Vertex(6), new Vertex(7));
            ArrayList<Edge> edges = new ArrayList<>();
            edges.add(a);
            edges.add(b);
            edges.add(c);
            edges.add(d);
            edges.add(e);
            edges.add(f);
            edges.add(g);
            edges.add(h);
            edges.add(i);
            edges.add(j);

            d1 = new Dag(edges);
        }

        if(DAGSELECTION == 3) {
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

            d1 = new Dag(edges);
        }

        System.out.println(d1);
        System.out.println("Topologically sorting dag...");
        Stack<Long> sorted = DagFunctions.topologicalSort(d1);
        List<List<Edge>> adjList = DagFunctions.adjacencyUtil(d1.getEdgeList());
        System.out.println("Sorted Stack using topological sort");
        System.out.println(sorted);

        // Change last paramanter to whichever vertex you would like to start from.
        DagFunctions.findLongestPath(d1.getNodeCount(), adjList, sorted, 7);

    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
