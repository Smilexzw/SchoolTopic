package javacode;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * @author xuzhangwang
 * @date 2019/7/25
 */
public class LambadaTest {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a", "b", "c", "d", "c");
//        list.sort(String::compareTo);
//        list.sort(Comparator.reverseOrder());
//        System.out.println(list.toString());
//
//
//        List<String> stringList = new ArrayList<>();
//        stringList.add("ddd2");
//        stringList.add("aaa2");
//        stringList.add("bbb1");
//        stringList.add("aaa1");
//        stringList.add("bbb3");
//        stringList.add("ccc");
//        stringList.add("bbb2");
//        stringList.add("ddd1");
//
//        long count = stringList.stream()
//                .filter((s) -> s.startsWith("a"))
//                .count();
//        System.out.println(count);

        // 创建没有重复元素的大表
//        int max = 100000;
//        List<String> list = new ArrayList<>(max);
//        for (int i = 0; i < max; i++) {
//            UUID uuid = UUID.randomUUID();
//            list.add(uuid.toString());
//        }
//
//        fun2(list);

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "val" + i);
        }

        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));
//        map.forEach((id, val) -> System.out.println(val));
    }

    private static void fun1(List<String> list) {
        // 串行排序
        long t0 = System.nanoTime();
        long count = list.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    private static void fun2(List<String> list) {
        // 串行排序
        long t0 = System.nanoTime();
        long count = list.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }
}
