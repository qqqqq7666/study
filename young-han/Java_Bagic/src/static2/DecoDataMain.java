package static2;

// import static static2.DecoData.staticCall;
import static static2.DecoData.*;
// static method 를 편하게 사용가능

public class DecoDataMain {

    public static void main(String[] args) {
        System.out.println("1. static call");
        staticCall();


        System.out.println("2. instance call1");
        DecoData data1 = new DecoData();
        data1.instanceCall();

        System.out.println("3. instance call2");
        DecoData data2 = new DecoData();
        data2.instanceCall();

        staticCall(data1);

        // 추가
        // 인스턴스를 통한 접근
        DecoData data3 = new DecoData();
        data3.staticCall(); // 인스턴스인지 static 인지 구분이 안됨

        // 클래스를 통한 접근
        staticCall();

    }
}
