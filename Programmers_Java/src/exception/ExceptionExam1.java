package exception;

public class ExceptionExam1 {

    public static void main(String[] args) {
        int i = 10;
        int j = 0;
        try {
            int k = i / j;
            System.out.println(k);
        } catch (ArithmeticException e){
            System.out.println("can not divide by 0 " + e.toString());
        } finally {
            System.out.println("무조건 실행");
        }

        System.out.println("main end");
    }
}
