package static2.ex;

import java.util.Arrays;
import java.util.OptionalInt;

public class MathArrayUtils {

    private MathArrayUtils(){}
    // private 인스턴스 생성 차단

    public static int sum(int[] array){
        int res = 0;
        for(int n : array)
            res += n;
        return res;
    }

    public static double average(int[] array){
        return (double) sum(array) / array.length;
    }

    public static int min(int[] array){
        int res = Integer.MAX_VALUE;
        for(int n : array){
            if(res > n)
                res = n;
        }

        return res;
    }

    public static int max(int[] array){
        int res = Integer.MIN_VALUE;
        for(int n : array){
            if(res < n)
                res = n;
        }

        return res;
    }
}
