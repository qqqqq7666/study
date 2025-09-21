package access;

public class BankAccount {

    private int balance;

    public BankAccount() {
        balance = 0;
    }

    // public method: deposit

    public void deposit(int amount){
        if(isAmountValid(amount))
            balance += amount;
        else
            System.out.println("non-valid amount");
    }

    private boolean isAmountValid(int amount){
        // 금액이 0보다 커야함
        return amount > 0;
    }

    public void withdraw(int amount){
        if(isAmountValid(amount) && balance - amount >= 0)
            balance -= amount;
        else
            System.out.println("non-valid amount");
    }

    public int getBalance(){
        return balance;
    }
}
