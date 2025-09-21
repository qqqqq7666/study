package ref;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("before call dataA.value = " + dataA.value);
        changePrimitive(dataA);
        System.out.println("after call dataA.value = " + dataA.value);
    }

    static void changePrimitive(Data dataX){
        dataX.value = 20;
    }
}
