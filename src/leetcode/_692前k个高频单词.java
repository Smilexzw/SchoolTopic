package leetcode;

import java.util.*;

/**
 * @author xuzhangwang
 */
public class _692前k个高频单词 {
    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        topKFrequent(words, k);
    }

    /**
     * 使用hashmap + 大堆实现
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for (String word : map.keySet()) {
            heap.add(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }

        System.out.println(list.toString());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return new LinkedList<>();
    }
}
