package poly.ex.pay0;

import java.util.HashMap;
import java.util.Map;

public class PaySystemFind {
    public static Pay find(String option){
        Map<String, Pay> payMap = new HashMap<String, Pay>();
        payMap.putIfAbsent("kakao", new KakaoPay());
        payMap.putIfAbsent("naver", new NaverPay());
        if(payMap.containsKey(option))
            return payMap.get(option);
        else return new FailedPay();
    }
}
