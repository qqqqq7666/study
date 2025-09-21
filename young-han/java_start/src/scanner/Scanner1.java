package scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 입력 ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        n1 ^= n2;
        n2 ^= n1;
        n1 ^= n2;

        System.out.println(n1);
        System.out.println(n2);
    }
}
