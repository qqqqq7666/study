package exception.biz;

public class BizService {
    public void bizMethod(int i ) throws BizException{
        System.out.println("bizMethod start");

        if(i < 0)
            throw new BizException("parameter i must be more than 0");

        System.out.println("bizMethod end");
    }
}
