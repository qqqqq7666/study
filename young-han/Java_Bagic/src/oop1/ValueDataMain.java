package oop1;

public class ValueDataMain {
    public static void main(String[] args) {
        ValueData valueData = new ValueData();
        add(valueData);
        add(valueData);
        add(valueData);
        System.out.println("final : " + valueData.value);
    }

    static void add(ValueData valueData){
        valueData.value++;
        System.out.println("up " + valueData.value);
    }
}
