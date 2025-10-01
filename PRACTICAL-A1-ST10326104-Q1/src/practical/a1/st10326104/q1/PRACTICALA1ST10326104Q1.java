package practical.a1.st10326104.q1;

//References: Farrall, J., 2020, *Java Programming*, 9th ed.

import java.util.Scanner;
import static practical.a1.st10326104.q1.SeriesApp.launchMenu;

public class PRACTICALA1ST10326104Q1
{
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in); // Scanner for user input

        System.out.println("LATEST SERIES - 2025");
        System.out.println("*************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = read.nextLine(); // Capture user input

        if(choice.equals("1"))
        {
            launchMenu(); // Start main menu
        }
        else
        {
            System.out.println("Exiting Application...");
        }
    }
}
