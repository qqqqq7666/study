package access;

public class Speaker {
    private int volume;

    Speaker(int volume){
        this.volume = volume;
    }

    void volumeUp(){
        if(volume >= 100)
            System.out.println("volume Max");
        else{
            volume += 10;
            System.out.println("volume 10up");
        }
    }
    void volumeDown(){
        volume -= 10;
        System.out.println("volumeDown call");
    }

    void showVolume(){
        System.out.println("current volume: " + this.volume);
    }
}
