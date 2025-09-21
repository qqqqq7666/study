package oop1;

public class MusicPlayer {
    int volume;
    boolean isOn;

    void on(){
        isOn = true;
        System.out.println("music player start");
    }

    void off(){
        isOn = false;
        System.out.println("music player end");
    }

    void volumeUp(){
        volume++;
        System.out.println("volume: " + volume);
    }

    void volumeDown(){
        volume--;
        System.out.println("volume: " + volume);
    }

    void showStatus(){
        if(isOn)
            System.out.println("music player ON, volume: " + volume);
        else
            System.out.println("music player OFF");
    }
}
