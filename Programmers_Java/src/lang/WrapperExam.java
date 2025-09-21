package lang;

public class WrapperExam {

    public static void main(String[] args) {
        int i = 5;
        // auto Boxing
        Integer i3 = i;
        int i4 = i3.intValue();

        // auto unBoxing
        int i5 = i3;

        System.out.println(i3);
    }
}
