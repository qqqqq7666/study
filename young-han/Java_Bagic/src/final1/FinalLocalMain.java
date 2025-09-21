package final1;

public class FinalLocalMain {
    public static void main(String[] args) {
        final int data1;
        data1 = 10; // 최초 1회만 할당 가능
        // data1 = 20; 컴파일 오류

        final int data2 = 10;

        method(10);
    }

    static void method(final int parameter){
        // parameter = 20; 컴파일 오류
    }
}
