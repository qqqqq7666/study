import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String num = scan.next();
        int B = scan.nextInt();
        int res = 0;
        int mul = 0;
        scan.close();

        for(int i = num.length() - 1; i >= 0; i--){
            int n = num.charAt(i) - 48;
            if(n >= 10)
                n -= 7;
            res += Math.pow(B, mul++) * n;
        }

        System.out.println(res);
    }
}