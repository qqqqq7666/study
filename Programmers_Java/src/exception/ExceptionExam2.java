package exception;

public class ExceptionExam2 {
    public static void main(String[] args) {
        int i = 10;
        int j = 0;
        int k = divide(i, j);
        System.out.println(k);
    }

    private static int divide(int i, int j) throws ArithmeticException, ClassCastException{
        return i / j;
    }
}
