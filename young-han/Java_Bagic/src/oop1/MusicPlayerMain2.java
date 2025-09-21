package oop1;

public class MusicPlayerMain2 {
    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();
        on(data);
        volumeUp(data);
        volumeUp(data);
        volumeDown(data);
        showState(data);
        off(data);
    }

    static void on(MusicPlayerData data){
        data.isOn = true;
        System.out.println("music player start");
    }

    static void off(MusicPlayerData data){
        data.isOn = false;
        System.out.println("music player end");
    }

    static void volumeUp(MusicPlayerData data){
        data.volume++;
        System.out.println("volume up");
        System.out.println("volume: " + data.volume);
    }

    static void volumeDown(MusicPlayerData data){
        data.volume--;
        System.out.println("volume down");
        System.out.println("volume: " + data.volume);
    }

    static void showState(MusicPlayerData data){
        if(data.isOn)
            System.out.println("music player on, volume: " + data.volume);
        else
            System.out.println("music player off");

    }
}