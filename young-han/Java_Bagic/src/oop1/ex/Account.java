package oop1.ex;

public class Account {
    int balance;

    void deposit(int money){
        balance += money;
        System.out.println("balance = " + balance);
    }

    void withdraw(int money){
        if(balance - money > 0){
            balance -= money;
            System.out.println("balance = " + balance);
        }
        else {
            System.out.println("not enough money");
            System.out.println("balance = " + balance);
        }
    }
}
