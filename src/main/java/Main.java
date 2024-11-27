import models.BankAccount;
import models.Customer;
import models.User;

public class Main {
    public static void main(String[] args){
        // Admin Menu Options
        private static void showAdminMenu() {
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    loggedInUser = null;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        // Admin functionality: View all users
        private static void viewAllUsers() {
            System.out.println("All users:");
            for (User user : userService.getAllUsers(loggedInUser)) {
                System.out.println(user.getName() + " (" + user.getRole() + ")");
            }
        }

        // Admin functionality: Delete a user
        private static void deleteUser() {
            System.out.print("Enter user ID to delete: ");
            String userId = scanner.nextLine();
            if (userService.deleteUser(userId, loggedInUser)) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Failed to delete user.");
            }
        }

        // Customer Menu Options
        private static void showCustomerMenu() {
            System.out.println("1. Check Balance");
            System.out.println("2. Transfer Funds");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    transferFunds();
                    break;
                case 3:
                    loggedInUser = null;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        // Customer functionality: Check balance
        private static void checkBalance() {
            if (loggedInUser instanceof Customer) {
                Customer customer = (Customer) loggedInUser;
                System.out.println("Balance: " + customer.getAccount().checkBalance());
            } else {
                System.out.println("Access Denied.");
            }
        }

        // Customer functionality: Transfer funds
        private static void transferFunds() {
            if (loggedInUser instanceof Customer) {
                Customer customer = (Customer) loggedInUser;
                System.out.print("Enter recipient's user ID: ");
                String recipientId = scanner.nextLine();
                System.out.print("Enter transfer amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                // Find recipient customer
                User recipient = userService.getAllUsers(loggedInUser).stream()
                        .filter(u -> u.getUserId().equals(recipientId) && u instanceof Customer)
                        .findFirst().orElse(null);

                if (recipient != null) {
                    BankAccount recipientAccount = ((Customer) recipient).getAccount();
                    if (customer.getAccount().transferFunds(recipientAccount, amount)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed (check balance or amount).");
                    }
                } else {
                    System.out.println("Recipient not found.");
                }
            } else {
                System.out.println("Access Denied.");
            }


    }
}