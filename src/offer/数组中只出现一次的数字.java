package offer;

/**
 * @author xuzhangwang
 */
public class 数组中只出现一次的数字 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 1, 4};
        FindNumsAppearOnce(arr, new int[] {0}, new int[] {0});
    }


    /**
     * diff &= -diff得到diff最右边不为0的位，也就是不存在重复的两个元素在位级上表示最右侧不同那一个位置。
     * @param nums
     * @param num1
     * @param num2
     */
    public static void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
