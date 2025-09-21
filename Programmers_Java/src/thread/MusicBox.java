package thread;

public class MusicBox {

    // synchronized 매서드가 끝날 때 까지 다른 매서드가 실행 되지 않음
    public synchronized void playMusicA(){
        for (int i = 0; i < 10; i++) {
            System.out.println("신나는 음악");

            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void playMusicB(){
        for (int i = 0; i < 10; i++) {
            System.out.println("슬픈 음악");

            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public  void playMusicC(){
        for (int i = 0; i < 10; i++) {
            System.out.println("카페 음악");

            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
