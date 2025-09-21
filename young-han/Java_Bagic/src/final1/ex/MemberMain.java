package final1.ex;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("myId1", "kim");
        member.print();
        member.changeData("myId2", "seo");
        member.print();

    }
}
