package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExam {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        boolean flag1 = set1.add("jin");
        boolean flag2 = set1.add("lee");
        boolean flag3 = set1.add("jin");

        System.out.println(set1.size());

        System.out.println("flag1 = " + flag1);
        System.out.println("flag2 = " + flag2);
        System.out.println("flag3 = " + flag3);

        Iterator<String> iter = set1.iterator();

        System.out.println(iter);

        while (iter.hasNext()){
            String str = iter.next();
            System.out.println(str);
        }
    }
}
