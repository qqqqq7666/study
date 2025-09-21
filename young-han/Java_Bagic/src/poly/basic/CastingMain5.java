package poly.basic;

public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 called");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2 called");
        call(parent2);

        boolean flag = parent1 instanceof Child;
    }

    private static void call(Parent parent){
        parent.parentMethod();
        if(parent instanceof Child child) {
            System.out.println("Child instance 맞다");
            child.childMethod();
        }
        else
            System.out.println("Child instance 아니다");
    }
}
