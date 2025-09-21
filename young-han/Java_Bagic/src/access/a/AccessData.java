package access.a;

public class AccessData {
    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod(){
        System.out.println("publicMethod called " + publicField);
    }

    void defaultMethod(){
        System.out.println("defaultMethod called " + defaultField);
    }

    private void privateMethod(){
        System.out.println("publicMethod called " + privateField);
    }

    public void innerAccess(){
        System.out.println("inner called");
        publicField = 100;
        defaultField = 200;
        privateField = 300;
        publicMethod();;
        defaultMethod();
        privateMethod();
    }
}
