import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    // Constants for the game
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;
    private static final int MAX_ATTEMPTS = 7;
    private static final int ROUNDS = 3;

    // Scanner for user input
    private static Scanner scanner = new Scanner(System.in);

    // Main method to start the game
    public static void main(String[] args) {
        System.out.println("Welcome to the Guess the Number Game!");

        // Track the number of rounds won
        int roundsWon = playGame();

        // Display final score
        System.out.println("\nGame over! Your score is: " + roundsWon);
    }

    // Play the game with multiple rounds
    private static int playGame() {
        int roundsWon = 0;

        // Play multiple rounds
        for (int round = 1; round <= ROUNDS; round++) {
            System.out.println("\nRound " + round + " of " + ROUNDS);

            // Generate a random number for this round
            int secretNumber = generateRandomNumber(RANGE_START, RANGE_END);

            // Play the round and check if the user won
            if (playRound(secretNumber)) {
                roundsWon++;
            }
        }

        return roundsWon;
    }

    // Generates a random number within the given range
    private static int generateRandomNumber(int rangeStart, int rangeEnd) {
        Random random = new Random();
        return rangeStart + random.nextInt(rangeEnd - rangeStart + 1);
    }

    // Play a single round of the game
    private static boolean playRound(int secretNumber) {
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess (attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + "): ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number.");
                return true; // User won this round
            } else if (userGuess < secretNumber) {
                System.out.println("The number is higher than your guess.");
            } else {
                System.out.println("The number is lower than your guess.");
            }
        }

        // If user didn't guess the number in the allowed attempts
        System.out.println("Sorry! You've reached the maximum attempts. The secret number was: " + secretNumber);
        return false; // User lost this round
    }
}
