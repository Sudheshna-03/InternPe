import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Enter your choice: Rock, Paper, or Scissors (or exit to end):");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("exit")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            int computerChoice = random.nextInt(3); // 0 for Rock, 1 for Paper, 2 for Scissors

            System.out.println("Computer chose:");

            switch (computerChoice) {
                case 0:
                    System.out.println("Rock");
                    break;
                case 1:
                    System.out.println("Paper");
                    break;
                case 2:
                    System.out.println("Scissors");
                    break;
            }

            System.out.println("You chose: " + userChoice);

            if (userChoice.equals("rock") && computerChoice == 2 ||
                userChoice.equals("paper") && computerChoice == 0 ||
                userChoice.equals("scissors") && computerChoice == 1) {
                System.out.println("Congratulations! You win!");
            } else if (userChoice.equals("rock") && computerChoice == 1 ||
                    userChoice.equals("paper") && computerChoice == 2 ||
                    userChoice.equals("scissors") && computerChoice == 0) {
                System.out.println("Sorry, you lose. Try again!");
            } else {
                System.out.println("It's a tie! Try again.");
            }
        }

        scanner.close();
    }
}
