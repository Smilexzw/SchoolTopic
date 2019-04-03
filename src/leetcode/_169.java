package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description: 求众数
 */
public class _169 {
    static int[] arr = {2, 2, 1, 1, 1, 2, 2};

    public static void main(String[] args) {
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cur = nums[i + 1];
                }
            }
        }
        return cur;
    }
}
