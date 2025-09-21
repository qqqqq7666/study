package exception;

public class ExceptionExam3 {
    public static void main(String[] args) {
        int i = 10;
        int j = 0;
        int k = divide(i, j);

        System.out.println(k);
    }

    private static int divide(int i, int j) {
        if(j == 0){
            throw new IllegalArgumentException("2th parameter can not be 0");
        }

        return i / j;
    }
}
