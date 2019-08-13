package code;

import java.util.*;
import java.util.Comparator;

/**
 * 使用PriorityQueue完成大堆和小堆
 *
 * @author xuzhangwang
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        int[] nusm = {4, 5, 1, 6, 2, 7, 3, 8, 8, 8, 8, 8};
        int k = 4;
        int[] max = findKMax(nusm, k);
        int[] min = findKMin(nusm, k);
        System.out.println("TopK最小k个数的数组" + Arrays.toString(min));
        System.out.println("TopK最大k个数的数组" + Arrays.toString(max));

        GetLeastNumbers_Solution(nusm, k);
    }


    /**
     * 找出前k个最大数，采用小顶堆实现
     *
     * @param nums 数组
     * @param k    前k的数字
     * @return 前k个最大数字的数组
     */
    public static int[] findKMax(int[] nums, int k) {
        // PriorityQueue（优先队列）一个基于优先级别的无界优先队列
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (minHeap.peek() < num) {
                // 如果堆顶元素小于要添加的数字，就删除堆顶元素，将新的数字加入到堆中
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }


    /**
     * 使用PriorityQueue完成最小的k个数组查找
     * @param nums 要排序的数组
     * @param k 最小的k个数字
     * @return 返回最小数字的数组
     */
    public static int[] findKMin(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k < 0) {
            return null;
        }

        int[] res = new int[k];
        PriorityQueue<Integer> max = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            if (max.size() < k) {
                max.offer(num);
            } else if (max.peek() > num) {
                // 如果堆顶元素大于新的数字，就删除堆顶，将新的数字添进去
                max.poll();
                max.offer(num);
            }
        }

        for (int i = 0; i < k && !max.isEmpty(); i++) {
            res[i] = max.poll();
        }
        return res;
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k < 0) return list;
        PriorityQueue<Integer> max = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : input) {
            if (max.size() < k) {
                max.offer(num);
            } else if (max.peek() > num) {
                // 如果堆顶元素大于新的数字，就删除堆顶，将新的数字添进去
                max.poll();
                max.offer(num);
            }
        }

        while (max.size() != 0) {
            list.add(max.poll());
        }

        Collections.sort(list);
        return list;
    }
}
