
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdminAccount adminAccount = new AdminAccount();
        UserAccount currentUser = null;

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Login as User");
            System.out.println("3. Login as Admin");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    System.out.println("Enter Account Type  ");
                    System.out.println("1.Savings");
                    System.out.println("2. Current");
                    String userType = scanner.nextLine();

                    if( userType.equals("Savings"))
                    {
                        UserAccount newUser = new savingsAcc(newUsername,newPassword);
                        adminAccount.addUser(newUser);
                        System.out.println("created savings Account");
                    }
                   if (userType.equals("Current"))
                    {
                        UserAccount newUser = new CurrentAcc(newUsername,newPassword);
                        adminAccount.addUser(newUser);
                        System.out.println("created current Account");
                    }




                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    currentUser = authenticateUser(username, password, adminAccount);
                    if (currentUser != null) {
                        System.out.println("Login successful as " + currentUser.getUsername());
                    } else {
                        System.out.println("Invalid credentials");
                    }
                    break;

                case 3:
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.nextLine();

                    if (adminPassword.equals("admin")) {
                        System.out.println("Select Option:");
                        System.out.println("View Users");
                        System.out.println("Add User");
                        scanner.nextLine();
                       /* if (scanner.nextLine().equals("View Users"))
                        {
                            adminAccount.viewUsers();
                        } else if (scanner.nextLine().equals("Add User"))
                        {
                         adminAccount.addUser(currentUser);
                        }*/
                        adminAccount.viewUsers();


                    }
                    else {
                        System.out.println("Invalid admin password");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

            if (currentUser != null) {
                performUserOperations(currentUser, scanner);
            }
        }
    }

    private static UserAccount authenticateUser(String username, String password, AdminAccount adminAccount) {
        UserAccount userAccount = adminAccount.getUserAccount(username);
        if (userAccount != null && userAccount.getPassword().equals(password)) {
            return userAccount;
        }
        return null;
    }

    private static void performUserOperations(UserAccount userAccount, Scanner scanner) {
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawalAmount);
                    break;

                case 3:
                    System.out.println("Current Balance: $" + userAccount.getBalance());
                    break;

                case 4:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}