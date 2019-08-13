package leetcode;

import java.util.*;

/**
 * @author xuzhangwang
 */
public class _341前k个高频元素 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        List<Integer> res = topKFrequent(nums, 2);
        System.out.println(res.toString());
    }

    /**
     * 查找出前k个高频元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 在使用小堆实现
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }


        List<Integer> top_k = new LinkedList<>();
        while (!heap.isEmpty()) {
            top_k.add(heap.poll());
        }

        Collections.sort(top_k);

        return top_k;

    }
}
