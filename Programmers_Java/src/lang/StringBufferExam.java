package lang;

public class StringBufferExam {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("world");
        String str = sb.toString();

        // 위 과정이 str = "hello" + " " + "world"와 같은 과정임

        System.out.println(str);
        System.out.println(sb.capacity());

        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = sb2.append("hellow");

        if(sb2 == sb3)
            System.out.println("sb2 == sb3");

        System.out.println(sb3);

        String str2 = new StringBuffer().append("Hello").append(" ").append("World").toString();
        System.out.println(str2);

    }
}
