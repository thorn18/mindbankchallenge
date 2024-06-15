
import java.util.Scanner;

import Functions.DagFunctions;
import models.Dag;

public class ChallengeRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter the size of the Dag you want to generate");
        String input = scanner.nextLine();
        while (!isNumeric(input)) {
            System.out.println("Not a number, Enter the size of the Dag you want to generate");
            input = scanner.nextLine();
        }
        int size = Integer.parseInt(input);

        Dag d1 = DagFunctions.createADag(size);
        System.out.println(d1);
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
