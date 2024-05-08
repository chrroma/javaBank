import java.util.Scanner;
import java.io.Console;

public class BankOne {
    static double savingsBalance = 2700.00;
    static double checkingsBalnance = 20.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available");
            System.exit(1);
        }
        String username = "beau";
        String password = "iLoveMyGF";
        boolean login = true;

        while (login) {
            System.out.println("Welcome to Java Banking! ");
            System.out.print("Username: ");
            String checkUser = console.readLine();

            if (checkUser.equals(username)) {
                char[] passwordChars = console.readPassword("Password: ");
                String checkPass = new String(passwordChars);

                if (checkPass.equals(password)) {
                    login = false;
                    System.out.println("You have successfully logged in!");
                    System.out.println(" ");
                    System.out.flush();
                    bankInfo();
                    modifyBalances(scanner);
                } else {
                    System.out.println("You have entered wrong login information!");
                }
            }
        }
    }
    static void bankInfo(){
        System.out.println("Here are your balances: ");
        System.out.println("Savings: $" + savingsBalance);
        System.out.println("Checking: $" + checkingsBalnance);
        System.out.println(" ");
    }
    static void modifyBalances(Scanner scanner){
        while(true) {
            System.out.println("Please select an option: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Logout");
            System.out.print("Enter your option: ");
            int option = scanner.nextInt();
            System.out.println(" ");
            if (option == 1) {
                deposit(scanner);
            }
            if (option == 2) {
                withdraw(scanner);
            }
            if (option == 3) {
                transfer(scanner);
            }
            if (option == 4) {
                System.out.println("Thank you for baking with us, enjoy your day!");
                System.exit(0);
            }
        }
    }
    static void deposit(Scanner scanner){
        System.out.println("Where would you like to deposit: ");
        System.out.println("1. Savings");
        System.out.println("2. Checking");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();
        System.out.println(" ");

        if (option == 1){
            System.out.print("Enter amount to deposit:");
            double amount = scanner.nextDouble();
            System.out.println(" ");
            savingsBalance += amount;
            System.out.println("You have successfully deposited $" + amount + " into your savings account");
            System.out.println(" ");
            bankInfo();
        }
        if (option == 2){
            System.out.print("Enter amount to deposit:");
            double amount = scanner.nextDouble();
            checkingsBalnance += amount;
            System.out.println("You have successfully deposited $" + amount + " into your checking account");
            System.out.println(" ");
            bankInfo();
        }
    }
    static void withdraw(Scanner scanner){
        System.out.println("Where would you like to withdraw: ");
        System.out.println("1. Savings");
        System.out.println("2. Checking");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();
        System.out.println(" ");

        if (option == 1){
            System.out.print("Enter amount to withdraw:");
            double amount = scanner.nextDouble();
            checkingsBalnance -= amount;
            System.out.print("You have successfully withdrew $" + amount + " from your savings account");
            System.out.println(" ");
            bankInfo();
        }
        if (option == 2){
            System.out.print("Enter amount to withdraw:");
            double amount = scanner.nextDouble();
            checkingsBalnance -= amount;
            System.out.println("You have successfully withdrew $" + amount + " from your checking account");
            System.out.println(" ");
            bankInfo();
        }
    }
    static void transfer(Scanner scanner){
        System.out.println("Where would like to transfer money too: ");
        System.out.println("1.Between accounts ");
        System.out.println("2.To another person ");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();
        System.out.println(" ");

        if (option == 1){
            System.out.println("Where would like to transfer money from: ");
            System.out.println("1.Checking to Savings");
            System.out.println("2.Saving to Checking");
            System.out.print("Please select an option: ");
            int option2 = scanner.nextInt();
            System.out.println(" ");

            if (option2 == 1){
                System.out.print("Enter amount to transfer: ");
                double amount = scanner.nextDouble();
                System.out.println(" ");
                if (amount > checkingsBalnance){
                    System.out.println("You do not have that much to transfer");
                    System.out.println(" ");
                }
                if (amount <= checkingsBalnance) {
                    checkingsBalnance -= amount;
                    savingsBalance += amount;
                    System.out.println("You transferred $" + amount + " to your checking account");
                    System.out.println(" ");
                    bankInfo();
                }
            }
            if (option2 == 2){
                System.out.print("Enter amount to transfer : ");
                double amount = scanner.nextDouble();
                System.out.println(" ");
                if (amount > savingsBalance){
                    System.out.println("You do not have that much to transfer");
                    System.out.println(" ");
                }
                if (amount <= savingsBalance) {
                    savingsBalance -= amount;
                    checkingsBalnance += amount;
                    System.out.println("You transferred $" + amount + " to your checking account");
                    System.out.println(" ");
                    bankInfo();
                }
            }
        }
        if (option == 2){
            System.out.println(" ");
            System.out.println("this feature coming soon");
            System.out.println(" ");
        }
    }
}

