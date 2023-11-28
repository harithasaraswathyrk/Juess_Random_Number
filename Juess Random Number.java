import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            playGame(scanner, random);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }
        }

        scanner.close();
    }

    private static void playGame(Scanner scanner, Random random) {
        // Step 1: Generate a random number within the specified range
        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Additional details
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("Guess the number between %d and %d.\n", lowerBound, upperBound);

        while (true) {
            // Step 2: Prompt the user to enter their guess
            System.out.printf("Attempts left: %d. Your guess: ", maxAttempts);
            int userGuess = scanner.nextInt();

            // Step 3: Compare the user's guess and provide feedback
            if (userGuess == secretNumber) {
                int score = maxAttempts * 10; // Score calculation
                System.out.printf("Congratulations! You guessed the correct number (%d) with a score of %d!\n", secretNumber, score);
                totalScore += score;
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            maxAttempts--;

            // Check if the user has run out of attempts
            if (maxAttempts == 0) {
                System.out.printf("Sorry, you've run out of attempts. The correct number was %d.\n", secretNumber);
                break;
            }
        }

        // Additional details
        roundsPlayed++;

        System.out.println("Round summary:");
        System.out.printf("Total score: %d\n", totalScore);
        System.out.printf("Rounds played: %d\n", roundsPlayed);
    }
}
