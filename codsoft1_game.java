import java.util.*;

public class codsoft1_game {
    private static final int maximum = 10;
    private static final int start = 1;
    private static final int end = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;
	System.out.println("Game starts!");

        while (playAgain) {
            int numberToGuess = random.nextInt(end - start + 1) + start;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A random number has been generated between " + start + " and " + end + ".");
            System.out.println("You have " + maximum + " attempts to guess it.\nGood Luck!");

            while (attempts < maximum && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < start || userGuess > end) {
                    System.out.println("Please enter a number between " + start + " and " + end + ".");
                    continue;
                }

                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all " + maximum + " attempts. The number was " + numberToGuess + ".");
            }

            score += guessedCorrectly ? maximum - attempts + 1 : 0;

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();  
            String userResponse = scanner.nextLine().trim().toLowerCase();

            if (!userResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }
}
