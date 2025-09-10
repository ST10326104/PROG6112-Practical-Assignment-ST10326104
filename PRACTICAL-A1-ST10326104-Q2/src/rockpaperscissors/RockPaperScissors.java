package RockPaperScissors;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("WELCOME TO ROCK, PAPER, SCISSORS!");
        System.out.println("Enter (1) Rock, (2) Paper, (3) Scissors, or any other key to exit.");

        while (true) {
            System.out.print("\nYour choice: ");
            String input = read.nextLine();
            Move playerMove;

            switch (input) {
                case "1": playerMove = new Rock(); break;
                case "2": playerMove = new Paper(); break;
                case "3": playerMove = new Scissors(); break;
                default:
                    System.out.println("Exiting game...");
                    return;
            }

            // Computer random move
            int compChoice = rand.nextInt(3);
            Move computerMove;
            if (compChoice == 0) computerMove = new Rock();
            else if (compChoice == 1) computerMove = new Paper();
            else computerMove = new Scissors();

            System.out.println("Computer chose: " + computerMove.getName());
            System.out.println(playerMove.compare(computerMove));
        }
    }
}
