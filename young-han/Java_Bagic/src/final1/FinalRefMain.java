package final1;

public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data();
        // data = new Data();
        // 참조값이 final 이므로 값을 변경할 수 없다.

        // 참조 대상의 값은 변경 가능

        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);

        // data의 인스턴스는 final이 아니므로 data.value는 변경 가능
    }
}
