package array;

import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input");
        int n = scanner.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int inputNum = scanner.nextInt();
            sum += inputNum;
        }

        System.out.println(sum);
        System.out.println((double) sum / n);

        int[] sArray = new int[3];
        sArray.
    }
}
