package oop1;

public class MusicPlayerMain1 {
    public static void main(String[] args) {
        int volume = 0;
        boolean isOn = false;

        isOn = true;
        System.out.println("music player start");

        volume++;
        System.out.println("volume up");
        System.out.println("volume: " + volume);

        volume--;
        System.out.println("volume down");
        System.out.println("volume: " + volume);

        System.out.println("music player state");
        if(isOn)
            System.out.println("music player on");
        else
            System.out.println("music player off");
    }
}
