package poly.ex.pay0;

import java.util.Scanner;

public class PayMain0 {
    public static void main(String[] args) {

        while (true){
            Scanner scanner = new Scanner(System.in);
            PayService payService = new PayService();

            System.out.print("결제 수단을 입력하세요:");
            String option = scanner.next();

            if(option.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("결제 금액을 입력하세요:");
            int amount = scanner.nextInt();
            payService.processPay(option, amount);
        }
    }
}
