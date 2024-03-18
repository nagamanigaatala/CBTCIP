import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int lowerBound = 1; 
        int upperBound = 100; 
        int attemptsLimit = 5; 
        int rounds = 3; 
        int totalScore = 0;

        // Game loop for multiple rounds
        for (int round = 1; round <= rounds; round++) {
            int randomNumber = generateRandomNumber(lowerBound, upperBound);
            int attempts = 0;
            boolean guessedCorrectly = false;

            // Guessing loop within the attempts limit
            while (attempts < attemptsLimit) {
                String userInput = JOptionPane.showInputDialog("Round " + round +
                        " - Guess the number between " + lowerBound + " and " + upperBound);
                int userGuess = Integer.parseInt(userInput);

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    int roundScore = calculateScore(attempts, attemptsLimit);
                    totalScore += roundScore;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number. Your score for this round: "
                            + roundScore + "\nTotal Score: " + totalScore);
                    break;
                } else if (userGuess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
                attempts++;
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Round " + round + " over. The correct number was: " + randomNumber);
            }
        }

        JOptionPane.showMessageDialog(null, "Game over! Your final score: " + totalScore);
    }

    // Method to generate a random number within the given range
    private static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    // Method to calculate the score based on the number of attempts
    private static int calculateScore(int attempts, int attemptsLimit) {
        double scorePercentage = (double) (attemptsLimit - attempts) / attemptsLimit * 100;
        return (int) scorePercentage;
    }
}
