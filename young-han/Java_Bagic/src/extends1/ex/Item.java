package extends1.ex;

public class Item {
    String name;
    int price;

    protected void print(){
        System.out.println("이름: " + name + " 가격: " + price);
    }

    protected int getPrice(){
        return price;
    }
}
