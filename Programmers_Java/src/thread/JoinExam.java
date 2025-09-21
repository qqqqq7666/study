package thread;

public class JoinExam {
    public static void main(String[] args) {
        MyThread5 thread = new MyThread5();
        thread.start();

        System.out.println("start");

        // join을 통해 thread가 끝날때 까지 기다렷다가 main을 종료
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("end");
    }
}
