package exception.biz;

public class BizMain {
    public static void main(String[] args) {
        BizService bizService = new BizService();
        bizService.bizMethod(5);
        bizService.bizMethod(-3);
    }
}
