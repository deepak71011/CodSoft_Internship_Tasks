import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int MAX_ATTEMPTS = 5;
        final int MIN = 1, MAX = 100;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int target = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round: Guess the number between " + MIN + " and " + MAX);
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                // Validate user input
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                guess = scanner.nextInt();

                if (guess == target) {
                    System.out.println("🎉 Congratulations! You guessed it right.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess > target) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("❌ You've run out of attempts. The number was: " + target);
                }
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame Over! Rounds won: " + roundsWon);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
