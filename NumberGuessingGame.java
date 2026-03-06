import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;

        System.out.println("\n\n=== Welcome to Number Guessing Game ===");

        char playAgain;

        do {
            totalRounds++;
            int number = random.nextInt(100) + 1;  // Generates number between 1-100
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds);
            System.out.println("You have " + maxAttempts + " attempts to guess the number (1-100)");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println(" Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess > number) {
                    System.out.println(" Too High!");
                } else {
                    System.out.println(" Too Low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println(" You lost! The correct number was: " + number);
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        // Final Score
        System.out.println("\n=== Game Over ===");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);

        sc.close();
    }
}