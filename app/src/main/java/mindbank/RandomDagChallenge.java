package mindbank;

import mindbank.Functions.DagFunctions;
import mindbank.models.Dag;
import mindbank.models.Edge;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class RandomDagChallenge {

    static Dag d1;
    /**
     * Main method which will run challenge using a primative Randomly Generated Dag (max 2 children per node, 1 Parentless node)
     * @param args
     */
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
        Stack<Long> sorted = DagFunctions.topologicalSort(d1);
        System.out.println(sorted);
        scanner.close();

        System.out.println("\nLongest Path");
        List<List<Edge>> adjList = DagFunctions.adjacencyUtil(d1.getEdgeList());


        //Change last paramanter to whichever vertex you would like to start from.
        DagFunctions.findLongestPath(d1.getNodeCount(),adjList, sorted, 1);

    }

    /**
     * Checking user input to make sure it is valid.
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
