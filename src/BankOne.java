import java.util.Scanner;

public class BankOne {
    static double savingsBalance = 2700.00;
    static double checkingsBalnance = 20.00;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "beau";
        String password = "iLoveMyGF";
        boolean login = true;

        while (login){
            System.out.println("Welcome to Java Banking! ");
            System.out.print("Please enter your username: ");
            String checkUser = scanner.nextLine();

            if (checkUser.equals(username)) {
                System.out.print("Please enter your password: ");
            }String checkPass = scanner.nextLine();
            if (checkPass.equals(password)){
                    login = false;
                    System.out.println("You have successfully logged in!");
                    bankInfo();
                    modifyBalances(scanner);
                } else {
                System.out.println("You have entered wrong login information!");

            }
        }
    }
    static void bankInfo(){
        System.out.println("Here are your balances !");
        System.out.println("Savings: " + savingsBalance);
        System.out.println("Checking: " + checkingsBalnance);
        System.out.println(" ");
    }
    static void modifyBalances(Scanner scanner){
        System.out.println("Please select an option: ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Logout");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();

        if (option == 1){
            deposit(scanner);
        }
        if (option == 2){
            withdraw(scanner);
        }
        if (option == 3){
            System.out.println("Thank you for baking with us, enjoy your day!");
            System.exit(0);
        }
    }
    static void deposit(Scanner scanner){
        System.out.println("Where would you like to deposit: ");
        System.out.println("1. Savings");
        System.out.println("2. Checking");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();

        if (option == 1){
            System.out.print("Enter amount to deposit:");
            double amount = scanner.nextDouble();
            savingsBalance += amount;
            System.out.println("You have successfully deposited $" + amount + " into your savings account");
            bankInfo();
        }
        if (option == 2){
            System.out.print("Enter amount to deposit:");
            double amount = scanner.nextDouble();
            checkingsBalnance += amount;
            System.out.println("You have successfully deposited $" + amount + " into your checking account");
            bankInfo();
        }
    }
    static void withdraw(Scanner scanner){
        System.out.println("Where would you like to withdraw: ");
        System.out.println("1. Savings");
        System.out.println("2. Checking");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();

        if (option == 1){
            System.out.print("Enter amount to withdraw:");
            double amount = scanner.nextDouble();
            checkingsBalnance -= amount;
            System.out.print("You have successfully withdrew $" + amount + " from your savings account");
            bankInfo();
        }
        if (option == 2){
            System.out.print("Enter amount to withdraw:");
            double amount = scanner.nextDouble();
            checkingsBalnance -= amount;
            System.out.println("You have successfully withdrew $" + amount + " from your checking account");
            bankInfo();
        }
    }
}

