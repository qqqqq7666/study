package method;

public class MethodEx1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        double avg = average(a, b, c);
        int x = 15;
        int y = 25;
        int z = 35;
        double avg2 = average(x, y, z);
    }

    public static double average(int a, int b, int c){
        double avg = (double) (a + b + c) / 3;
        System.out.println("평균값 :" + avg);
        return avg;
    }
}
