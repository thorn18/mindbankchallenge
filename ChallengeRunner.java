
import java.util.Scanner;

import Functions.DagFunctions;
import models.Dag;
import models.Edge;
import models.Vertex;

public class ChallengeRunner {

    static Dag d1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter the size of the Dag you want to generate");
        String input = scanner.nextLine();
        while (!isNumeric(input)) {
            System.out.println("Not a number, Enter the size of the Dag you want to generate");
            input = scanner.nextLine();
        }
        int size = Integer.parseInt(input);

        d1 = DagFunctions.createADag(size);
        System.out.println(d1);
        System.out.println("Topologically sorting dag...");
        DagFunctions.topologicalSort(d1);



        // System.out.println("Enter the UUID of the vertex you want to find");
        // input = scanner.nextLine();
        // Vertex v;
        // try {
        //     v = DagFunctions.findVertex(d1, input);
        //     System.out.println("Found the Vertex with ID: " + v.toString());
        //     try {
        //         System.out.println("Vertex Parent id: " + v.getParent().getID());
        //     } catch (Exception e) {
        //         System.out.println("Vertex is parent of dag");
        //     }
        //     System.out.println("Number of direct Children: " + getNumberOfChildren(v));
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     System.out.println("No Vertex with that uuid, please try again.");
        // }
    }

    /**
     * Gets the number of children from a vertex (direct)
     * @param v the vertex being searched. Assumes that findVertex() has already found the vertex.
     * @return the number of children
     */
    private static int getNumberOfChildren(Vertex v) {
        int counter = 0;
        for(Edge e: d1.getEdgeList()) {
            if(e.getOriginator().getID() == (v.getID())) {
                counter += 1;
            }
        }
        return counter;
    }

    public static boolean isNumeric(String str)
{
    for (char c : str.toCharArray())
    {
        if (!Character.isDigit(c)) return false;
    }
    return true;
}

}
