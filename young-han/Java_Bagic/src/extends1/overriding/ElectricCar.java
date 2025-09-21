package extends1.overriding;

public class ElectricCar extends Car {

    @Override
    public void move(){
        System.out.println("electric car move faster");
    }

    public void charge(){
        System.out.println("charge");
    }
}
