import java.util.Scanner;

interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double showBalance();
}

class BankAccount implements Account {
    long number;
    double balance;
    BankAccount(long number, double balance) {
        this.number=number;
        this.balance=balance;
    }
    public void deposit(double amount) {
        balance+=amount;
    }
    public void withdraw(double amount) {
        if (balance == 0) { System.err.println("ERROR: Insufficient balance"); }
        else if (balance < 0) { System.err.println("ERROR: Negative Balance."); }
        else
            balance-=amount;
    }
    public double showBalance() {
            return balance;
    }
}

public class Demo {
    public static void main(String[] args) {
        int type;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a/c number & bank balance: ");
        BankAccount ba = new BankAccount(sc.nextLong(),sc.nextDouble());
        while (true) { 
            System.out.println("Enter 1 to deposite money: ");
            System.out.println("Enter 2 to withdraw money: ");
            System.out.println("Enter 3 to show Bank Balance: ");
            System.out.println("Enter 4 to exit: ");
            System.out.println("Enter your choice: ");
            type = sc.nextInt();
            switch (type) {
                case 1:
                    System.out.println("Enter amount: ");
                    ba.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter amount: ");
                    ba.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Balance: " + ba.showBalance());
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}