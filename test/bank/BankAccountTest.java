package bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BankAccountTest {
    @Test
    void testDeposit() {
        BankAccount account =
                new BankAccount("Rahul", 1000);
        account.deposit(500);
        assertEquals(1500,account.getBalance());
    }
 @Test
    void testWithdraw()
            throws InsufficientFundsException {
      BankAccount account =
                new BankAccount("Rahul", 1000);
       account.withdraw(300);
       assertEquals(700,account.getBalance());
    }
@Test
    void testInsufficientBalance() {
 BankAccount account =
                new BankAccount("Rahul", 1000);
        assertThrows(
                InsufficientFundsException.class,
                () -> account.withdraw(5000));
    }
 @Test
    void testNegativeDeposit() {BankAccount account = new BankAccount("Rahul", 1000);
        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-100));
    }
}