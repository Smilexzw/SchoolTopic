package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] num = {10, 14, 12, 11};
        ArrayList<Integer> res = maxInWindows(num, 0);
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size < 1 || num.length < size) return null;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() == i - size) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && num[dq.peekLast()] < num[i]) {
                dq.removeLast();
            }
            dq.offerLast(i);
            if ((i + 1) >= size) {
                res.add(num[dq.peek()]);
            }
        }
        return res;
    }
}
