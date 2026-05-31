package bank;

public class Main {

    public static void main(String[] args) {

        try {

            BankAccount account =
                    new BankAccount("Rahul", 1000);

            account.deposit(500);

            account.withdraw(300);

            System.out.println(
                    "Current Balance: "
                    + account.getBalance()
            );

            account.printMiniStatement();

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}