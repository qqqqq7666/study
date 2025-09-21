package thread;

public class MusicBoxExam1 {
    public static void main(String[] args) {
        MusicBox box = new MusicBox();

        MusicPlayer lee = new MusicPlayer(1, box);
        MusicPlayer jin = new MusicPlayer(2, box);
        MusicPlayer kim = new MusicPlayer(3, box);

        lee.start();
        jin.start();
        kim.start();
    }
}
