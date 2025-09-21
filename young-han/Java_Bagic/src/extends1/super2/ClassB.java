package extends1.super2;

public class ClassB extends ClassA{

    public ClassB(int a){
        this(a, 200);
        // super(); // 기본 생성자 생략 가능
        System.out.println("ClassB constructor a = " + a);
    }

    public ClassB(int a, int b){
        super();
        System.out.println("ClassB constructor a = " + a + " b = " + b);
    }
}
