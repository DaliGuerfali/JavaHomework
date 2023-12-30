public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private int balance;

    BankAccount(int accountNumber, String accountHolderName, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Amount deposited should be positive");
            return;
        }
        this.balance += amount;
        System.out.printf("%s's Current Balance: $%d\n",this.getAccountHolderName(), this.getBalance());
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Amount withdrawn should be positive");
            return;
        }
        this.balance -= amount;
        System.out.printf("%s's Current Balance: $%d\n",this.getAccountHolderName(), this.getBalance());
    }

}
