package mindbank.Functions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Stack;

import mindbank.models.Vertex;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import mindbank.models.Dag;
import mindbank.models.Edge;

public class DagFunctionsTest {

    private static Dag testDag0;
    private static Dag testDag1;
    private static Dag testDag2;
    private static Dag testDag3;

    /**
     * Creating all the test Dags
     */
    @BeforeAll
    public static void setupTests() {

        //Creating Dags
        Edge a = new Edge(new mindbank.models.Vertex(0), new mindbank.models.Vertex(8));
        Edge b = new Edge(new mindbank.models.Vertex(1), new mindbank.models.Vertex(8));
        Edge c = new Edge(new mindbank.models.Vertex(2), new mindbank.models.Vertex(8));
        Edge d = new Edge(new mindbank.models.Vertex(3), new mindbank.models.Vertex(8));
        Edge e = new Edge(new mindbank.models.Vertex(4), new mindbank.models.Vertex(8));
        Edge f = new Edge(new mindbank.models.Vertex(5), new mindbank.models.Vertex(8));
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
        testDag0 = new Dag(edges);

        Edge a1 = new Edge(new Vertex(0), new Vertex(2));
        Edge b1 = new Edge(new Vertex(0), new Vertex(3));
        Edge c1 = new Edge(new Vertex(1), new Vertex(3));
        Edge d1 = new Edge(new Vertex(1), new Vertex(4));
        Edge e1 = new Edge(new Vertex(3), new Vertex(5));
        Edge f1 = new Edge(new Vertex(3), new Vertex(6));
        Edge g1 = new Edge(new Vertex(6), new Vertex(8));
        Edge h1 = new Edge(new Vertex(7), new Vertex(8));
        ArrayList<Edge> edges1 = new ArrayList<>();
        edges1.add(a1);
        edges1.add(b1);
        edges1.add(c1);
        edges1.add(d1);
        edges1.add(e1);
        edges1.add(f1);
        edges1.add(g1);
        edges1.add(h1);
        testDag1 = new Dag(edges1);

        Edge a2 = new Edge(new Vertex(0), new Vertex(1));
        Edge b2 = new Edge(new Vertex(0), new Vertex(2));
        Edge c2 = new Edge(new Vertex(0), new Vertex(3));
        Edge d2 = new Edge(new Vertex(1), new Vertex(5));
        Edge e2 = new Edge(new Vertex(2), new Vertex(4));
        Edge f2 = new Edge(new Vertex(2), new Vertex(6));
        Edge g2 = new Edge(new Vertex(3), new Vertex(5));
        Edge h2 = new Edge(new Vertex(4), new Vertex(7));
        Edge i2 = new Edge(new Vertex(5), new Vertex(7));
        Edge j2 = new Edge(new Vertex(6), new Vertex(7));
        ArrayList<Edge> edges2 = new ArrayList<>();
        edges2.add(a2);
        edges2.add(b2);
        edges2.add(c2);
        edges2.add(d2);
        edges2.add(e2);
        edges2.add(f2);
        edges2.add(g2);
        edges2.add(h2);
        edges2.add(i2);
        edges2.add(j2);
        testDag2 = new Dag(edges2);

        Edge a3 = new Edge(new mindbank.models.Vertex(0), new mindbank.models.Vertex(1));
        Edge b3 = new Edge(new mindbank.models.Vertex(1), new mindbank.models.Vertex(2));
        Edge c3 = new Edge(new mindbank.models.Vertex(3), new mindbank.models.Vertex(4));
        Edge d3 = new Edge(new mindbank.models.Vertex(4), new mindbank.models.Vertex(2));
        Edge e3 = new Edge(new mindbank.models.Vertex(5), new mindbank.models.Vertex(6));
        Edge f3 = new Edge(new mindbank.models.Vertex(6), new mindbank.models.Vertex(2));
        Edge g3 = new Edge(new mindbank.models.Vertex(7), new mindbank.models.Vertex(2));
        ArrayList<Edge> edges3 = new ArrayList<>();
        edges3.add(a3);
        edges3.add(b3);
        edges3.add(c3);
        edges3.add(d3);
        edges3.add(e3);
        edges3.add(f3);
        edges3.add(g3);
        testDag3 = new Dag(edges3);

    }

    @Test
    void testFindLongestPath0() {


        int selectedVertex  = 9;
        int nodecount  = 9;
        Stack<Long> topSort = new Stack<>();
        topSort.push((long)8);
        topSort.push((long)0);
        topSort.push((long)1);
        topSort.push((long)2);
        topSort.push((long)3);
        topSort.push((long)4);
        topSort.push((long)5);
        topSort.push((long)6);
        topSort.push((long)7);

        Stack<Long> Stackmutable0 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable1 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable2 = (Stack<Long>)topSort.clone();


        int longestPath0 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag0.getEdgeList()), Stackmutable0, 0);
        int longestPath1 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag0.getEdgeList()), Stackmutable1, 5);
        int longestPath2 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag0.getEdgeList()), Stackmutable2, 8);

        assertEquals(1,longestPath0);
        assertEquals(1,longestPath1);
        assertEquals(0,longestPath2);
    }

    @Test
    void testFindLongestPath1() {
        int nodecount  = 9;
        Stack<Long> topSort = new Stack<>();
        topSort.push((long)2);
        topSort.push((long)5);
        topSort.push((long)8);
        topSort.push((long)6);
        topSort.push((long)3);
        topSort.push((long)0);
        topSort.push((long)4);
        topSort.push((long)1);
        topSort.push((long)7);


        Stack<Long> Stackmutable0 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable1 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable2 = (Stack<Long>)topSort.clone();


        int longestPath0 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag1.getEdgeList()), Stackmutable0, 0);
        int longestPath1 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag1.getEdgeList()), Stackmutable1, 1);
        int longestPath2 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag1.getEdgeList()), Stackmutable2, 7);


        assertEquals(3,longestPath0);
        assertEquals(3,longestPath1);
        assertEquals(1,longestPath2);
    }

    @Test
    void testFindLongestPath2() {
        int nodecount  = 8;
        Stack<Long> topSort = new Stack<>();
        topSort.push((long)7);
        topSort.push((long)5);
        topSort.push((long)1);
        topSort.push((long)4);
        topSort.push((long)6);
        topSort.push((long)2);
        topSort.push((long)3);
        topSort.push((long)0);

        Stack<Long> Stackmutable0 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable1 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable2 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable3 = (Stack<Long>)topSort.clone();


        int longestPath0 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag2.getEdgeList()), Stackmutable0, 0);
        int longestPath1 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag2.getEdgeList()), Stackmutable1, 2);
        int longestPath2 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag2.getEdgeList()), Stackmutable2, 3);
        int longestPath3 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag2.getEdgeList()), Stackmutable3, 7);

        assertEquals(3,longestPath0);
        assertEquals(2,longestPath1);
        assertEquals(2,longestPath2);
        assertEquals(0,longestPath3);

    }

    @Test
    void testFindLongestPath3() {
        int nodecount  = 8;
        Stack<Long> topSort = new Stack<>();
        topSort.push((long)2);
        topSort.push((long)1);
        topSort.push((long)0);
        topSort.push((long)4);
        topSort.push((long)3);
        topSort.push((long)6);
        topSort.push((long)5);
        topSort.push((long)7);

        Stack<Long> Stackmutable0 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable1 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable2 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable3 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable4 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable5 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable6 = (Stack<Long>)topSort.clone();
        Stack<Long> Stackmutable7 = (Stack<Long>)topSort.clone();


        int longestPath0 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag3.getEdgeList()), Stackmutable0, 0);
        int longestPath1 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag3.getEdgeList()), Stackmutable1, 1);
        int longestPath2 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag3.getEdgeList()), Stackmutable2, 2);
        int longestPath3 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag3.getEdgeList()), Stackmutable3, 3);
        int longestPath4 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag3.getEdgeList()), Stackmutable4, 4);
        int longestPath5 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag3.getEdgeList()), Stackmutable5, 5);
        int longestPath6 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag3.getEdgeList()), Stackmutable6, 6);
        int longestPath7 = DagFunctions.findLongestPath(nodecount,DagFunctions.adjacencyUtil(testDag3.getEdgeList()), Stackmutable7, 7);


        assertEquals(2,longestPath0);
        assertEquals(1,longestPath1);
        assertEquals(0,longestPath2);
        assertEquals(2,longestPath3);
        assertEquals(1,longestPath4);
        assertEquals(2,longestPath5);
        assertEquals(1,longestPath6);
        assertEquals(1,longestPath7);
    }

    /**
     * Testing premade graph 0 topological sorting
     */
    @Test
    void testTopologicalPremade0() {

        Stack<Long> st = DagFunctions.topologicalSort(testDag0);
        Stack<Long> expected = new Stack<>();
        expected.push((long)8);
        expected.push((long)0);
        expected.push((long)1);
        expected.push((long)2);
        expected.push((long)3);
        expected.push((long)4);
        expected.push((long)5);
        expected.push((long)6);
        expected.push((long)7);

        assertEquals(expected, st);
    }

    /**
     * Testing premade graph 1 topological sorting
     */
    @Test
    void testTopologicalPremade1() {
        Stack<Long> st = DagFunctions.topologicalSort(testDag1);
        Stack<Long> expected = new Stack<>();
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

    /**
     * Testing premade graph 2 topological sorting
     */
    @Test
    void testTopologicalPremade2() {
        Stack<Long> st = DagFunctions.topologicalSort(testDag2);
        Stack<Long> expected = new Stack<>();
        expected.push((long)7);
        expected.push((long)5);
        expected.push((long)1);
        expected.push((long)4);
        expected.push((long)6);
        expected.push((long)2);
        expected.push((long)3);
        expected.push((long)0);

        assertEquals(expected, st);
    }

    /**
     * Testing premade graph 3 topological sorting
     */
    @Test
    void testTopologicalPremade3() {
        Stack<Long> st = DagFunctions.topologicalSort(testDag3);
        Stack<Long> expected = new Stack<>();
        expected.push((long)2);
        expected.push((long)1);
        expected.push((long)0);
        expected.push((long)4);
        expected.push((long)3);
        expected.push((long)6);
        expected.push((long)5);
        expected.push((long)7);

        assertEquals(expected, st);
    }
}
