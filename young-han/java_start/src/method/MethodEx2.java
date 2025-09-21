package method;

import java.io.StringReader;
import java.util.Scanner;

public class MethodEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 0;
        while(true){
            System.out.println("---------------------------------------");
            System.out.println("1. 입금 | 2. 출금 | 3. 잔액 확인 | 4. 종료");
            System.out.println("---------------------------------------");
            System.out.print("선택 : ");
            int num = scanner.nextInt();
            int money;
            switch (num){
                case 1 :
                    System.out.print("입금액을 입력하세요 : ");
                    money = scanner.nextInt();
                    balance = bankingSystem(money, balance, true);
                    break;
                case 2:
                    System.out.print("출금액을 입력하세요 : ");
                    money = scanner.nextInt();
                    balance = bankingSystem(money, balance, false);
                    break;
                case 3:
                    System.out.println("현재 잔액 : " + balance);
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 명령어");
            }
        }
    }

    public static int bankingSystem(int money, int balance, boolean flag) {
        int res = balance;
        if (flag) {
            res += money;
            System.out.println(money + "원을 입금하였습니다. 현재 잔액: " + res + "원");
        } else if (balance < money) {
            System.out.println(money + "원을 출금하려 했으나 잔액이 부족합니다.");
        } else {
            res -= money;
            System.out.println(money + "원을 출금하였습니다. 현재 잔액: " + res + "원");
        }
        return res;
    }
}
