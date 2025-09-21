package object;

public class Student {
    String name;
    String number;
    int birthYear;

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "qqq";
        s1.number = "1234";
        s1.birthYear = 1994;

        Student s2 = new Student();
        s2.name = "qqq";
        s2.number = "1234";
        s2.birthYear = 1994;

        if(s1.equals(s2))
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");;

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(Integer.toString(s2.birthYear));



    }
}
