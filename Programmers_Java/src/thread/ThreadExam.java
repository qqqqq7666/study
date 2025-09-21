package thread;

public class ThreadExam {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("*");
        MyThread1 t2 = new MyThread1("-");

        t1.start();
        t2.start();

        // main은 종료 됐지만 다른 thread가 실행된다
        System.out.println("main end!");
    }
}
