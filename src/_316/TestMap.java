package _316;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author xuzhangwang
 * @date 2019/8/7
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        System.out.println(map.containsKey(1));
        Hashtable<Object, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < 10; i++) {
            hashtable.put(i,i);
        }
        hashtable.put("asd", 1);
        System.out.println(hashtable.contains("asd"));
    }
}
