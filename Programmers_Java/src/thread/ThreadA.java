package thread;

public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized (b){
            try {
                System.out.println("b가 완료될 때 까지 기다림");
                b.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Total : " + b.total);
        }
    }
}
