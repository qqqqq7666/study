package static2;

public class DecoData {
    private int instanceValue;
    private static int staticValue;

    public static void staticCall(){
        // instanceValue++;
        // instanceMethod();

        staticValue++;
        staticMethod();
    }

    public static void staticCall(DecoData data){
        data.instanceValue++;
        data.instanceMethod();
    }

    public void instanceCall(){
        instanceValue++;
        instanceMethod();;

        staticValue++;
        staticMethod();
    }

    private void instanceMethod(){
        System.out.println("instanceValue = " + instanceValue);
    }

    private static void staticMethod(){
        System.out.println("staticValue = " + staticValue);
    }
}
