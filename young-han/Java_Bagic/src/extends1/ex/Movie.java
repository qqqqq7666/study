package extends1.ex;

public class Movie extends Item{
    String director;
    String actor;
    Movie(String _name, int _price, String director, String actor){
        name = _name;
        price = _price;
        this.director = director;
        this.actor = actor;
    }

    @Override
    public void print(){
        super.print();
        System.out.println("- 감독: " + director + " 배우: " + actor);
    }
}
