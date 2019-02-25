package yearof2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 好未来_求众数 {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], new Integer(1));
            } else {
                // 不为空则覆盖其键，并将其值递增加1 用以计算其出现的次数
                map.put(nums[i], map.get(nums[i]) + 1);
            }

        }

        for (Integer s : map.keySet()) {
            if (map.get(s) >= (nums.length/2)) {
                result = s;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 用string 数组来存放数据
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(majorityElement(arr));

    }
}
