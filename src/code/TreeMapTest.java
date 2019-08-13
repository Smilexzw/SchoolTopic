package code;

import java.util.*;
import java.util.Comparator;

/**
 * @author xuzhangwang
 * @date 2019/7/25
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("a", 4);
        map.put("d", 3);
        map.put("c", 2);
        map.put("b", 1);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
