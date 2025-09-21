package extends1.ex;

public class Album extends Item{
    String artist;
    Album(String _name, int _price, String artist){
        name = _name;
        price = _price;
        this.artist = artist;
    }

    @Override
    public void print(){
        super.print();
        System.out.println("- 아티스트: " + artist);
    }
}
