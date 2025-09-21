package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("001", "kim");
        map.put("002", "lee");
        map.put("003", "jin");

        map.put("001", "kang");

        System.out.println(map.size());

        System.out.println(map.get("001"));
        System.out.println(map.get("002"));

        Set<String> keys = map.keySet();

        Iterator<String> iter = keys.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next() + ":" + map.get(iter.next()));
        }

        for(String s : map.keySet()){
            System.out.println(s + ":" + map.get(s));
        }
    }
}
