package com.example;

public class BankApplication {
    private String accountNum;
    private String name;
    private int balance;

    public BankApplication(String accountNum, String name, int balance){
        this.accountNum = accountNum;
        this.name = name;
        this.balance = balance;

        System.out.println("결과: 계좌가 생성되었습니다.");
    }

    private BankApplication(BankApplication bankApplication){
        this(bankApplication.accountNum, bankApplication.name, bankApplication.balance);
    }

    public void getAccountList(){
        System.out.println(accountNum + "\t" + name + "\t" + balance);
    }

    public void deposit(int money){
        balance += money;
        System.out.println("결과: 예금이 성공되었습니다.");
    }

    public void withdrawal(int money){
        if(balance - money < 0)
            System.out.println("출금이 실패하였습니다.");
        else{
            balance -= money;
            System.out.println("출금이 성공하였습니다.");
        }
    }
}
