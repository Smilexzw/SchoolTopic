package offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 和为S的连续正序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 15;
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(sum);
        for (ArrayList<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int low = 1;
        int high = 2;
        while (high > low) {
            // 应为是等差数列所以有
            int cur = (low + high) * (high - low + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                res.add(list);
                low++;
            } else if (cur < sum) {
                high++;
            } else {
                low++;
            }
        }
        return res;
    }

}
