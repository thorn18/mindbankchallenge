package mindbank.Functions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import mindbank.models.Dag;
import mindbank.models.Edge;

public class DagFunctionsTest {



    @Test
    void testAdjacencyUtil() {

    }

    @Test
    void testFindLongestPath() {

    }

    @Test
    void testTopologicalSortPremade1() {
        Edge a = new Edge(new mindbank.models.Vertex(0), new mindbank.models.Vertex(2));
        Edge b = new Edge(new mindbank.models.Vertex(0), new mindbank.models.Vertex(3));
        Edge c = new Edge(new mindbank.models.Vertex(1), new mindbank.models.Vertex(3));
        Edge d = new Edge(new mindbank.models.Vertex(1), new mindbank.models.Vertex(4));
        Edge e = new Edge(new mindbank.models.Vertex(3), new mindbank.models.Vertex(5));
        Edge f = new Edge(new mindbank.models.Vertex(3), new mindbank.models.Vertex(6));
        Edge g = new Edge(new mindbank.models.Vertex(6), new mindbank.models.Vertex(8));
        Edge h = new Edge(new mindbank.models.Vertex(7), new mindbank.models.Vertex(8));
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
        Stack<Long> st = new Stack<>();
        st = DagFunctions.topologicalSort(d1);
        Stack<Long> expected = new Stack<Long>();
        expected.push((long)2);
        expected.push((long)5);
        expected.push((long)8);
        expected.push((long)6);
        expected.push((long)3);
        expected.push((long)0);
        expected.push((long)4);
        expected.push((long)1);
        expected.push((long)7);

        assertEquals(expected, st);

    }
}
