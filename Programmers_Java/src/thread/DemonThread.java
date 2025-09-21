package thread;

public class DemonThread implements Runnable{
    @Override
    public void run(){
        while(true){
            System.out.println("데몬 쓰레드가 실행중");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DemonThread());
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(2000);

        System.out.println("메인 종료");
    }
}
