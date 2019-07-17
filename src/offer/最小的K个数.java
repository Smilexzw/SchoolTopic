package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xuzhangwang
 */
public class 最小的K个数 {
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> res = GetLeastNumbers_Solution(input, k);
        System.out.println(res.toString());
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k < 0) return list;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
}
