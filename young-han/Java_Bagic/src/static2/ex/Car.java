package static2.ex;

public class Car {
    String carName;
    static int cnt;

    Car(String name){
        carName = name;
        System.out.println("차량 구입, 이름: " + carName);
        cnt++;
    }

    static void showTotalCars(){
        System.out.println("구매한 차량 수: " + cnt);
    }
}
