package lang;

public class MathExam {

    public static void main(String[] args) {
        int value1 = Math.max(5, 30);
        System.out.println(value1);

        int value2 = Math.min(5, 30);
        System.out.println(value2);

        System.out.println(Math.abs(-10));
        // 0 이상 1.0 미만의 double 반환
        System.out.println(Math.random());

        System.out.println(Math.sqrt(25));
        System.out.println((int) Math.pow(2, 4));

        System.out.println(Math.absExact(-3123));
    }
}
