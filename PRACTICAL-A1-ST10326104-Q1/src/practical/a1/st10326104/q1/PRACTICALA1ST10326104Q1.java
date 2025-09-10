package practical.a1.st10326104.q1;

import java.util.Scanner;
import static practical.a1.st10326104.q1.SeriesApp.launchMenu;

public class PRACTICALA1ST10326104Q1
{

    public static void main(String[] args)
{
    Scanner read = new Scanner(System.in);
    
    System.out.println("LATEST SERIES - 2025");
    System.out.println("*************************************");
    System.out.println("Enter (1) to launch menu or any other key to exit: ");
    String choice = read.nextLine();

    if(choice.equals("1"))
    {
        launchMenu();
    }
    else
    {
        System.out.println("Exiting Application...");
    }
}

    
}
