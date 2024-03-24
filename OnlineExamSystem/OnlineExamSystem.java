import java.util.Scanner;

public class OnlineExamSystem {
    private static String username;
    private static String password;
    private static boolean loggedIn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Select Answers for MCQs");
            System.out.println("4. Timer and Auto Submit");
            System.out.println("5. Close Session and Logout");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    updateProfileAndPassword(scanner);
                    break;
                case 3:
                    selectAnswersForMCQs(scanner);
                    break;
                case 4:
                    startTimerAndAutoSubmit();
                    break;
                case 5:
                    closeSessionAndLogout();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();
        loggedIn = true;
        System.out.println("Login successful.");
    }

    private static void updateProfileAndPassword(Scanner scanner) {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.print("Enter new username: ");
        username = scanner.nextLine();
        System.out.print("Enter new password: ");
        password = scanner.nextLine();
        System.out.println("Profile and password updated successfully.");
    }

    private static void selectAnswersForMCQs(Scanner scanner) {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.println("Selecting answers for MCQs...");
        
        System.out.println("Answers selected successfully.");
    }

    private static void startTimerAndAutoSubmit() {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.println("Starting timer and auto submit...");
        
        System.out.println("Time's up! Exam submitted.");
    }

    private static void closeSessionAndLogout() {
        loggedIn = false;
        System.out.println("Session closed and logged out.");
    }
}
