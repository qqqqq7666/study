package extends1.super2;

public class ClassC extends ClassB{
    public ClassC(){
        // super(); // 기본생성자가 있을 경우에만 가능
        super(10, 20);
        System.out.println("ClassC constructor");
    }
}
