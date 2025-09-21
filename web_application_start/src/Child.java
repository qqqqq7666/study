public class Child extends Parent{
    public void childMethod(){
        System.out.println("ccc");
    }

    @Override
    public void parentMethod(){
        System.out.println("override ppp");
    }

    public void justMethod(){
        System.out.println("just do it!");
    }

    public void superMethod(){
        System.out.println("call super");
        super.parentGood();
    }
}
