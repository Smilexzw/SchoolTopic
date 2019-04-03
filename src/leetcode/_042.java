package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述 接雨水
 * 评论 (119)
 * 题解
 * 提交记录
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，
 * 在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 *           *
 *       *   ** *
 *   [ * ** ******]
 *         l r
 *
 *    leftMax  = 0
 *    rightMax = 0
 *    res = (1 - 0) = 0  l = 2 r = 10
 *    res = 1 + (2 - 1) = 2
 *    res = 2 + (2 - 1) = 3
 *    res = 3 + (2 - 0) = 5;
 *    res = 5 + (2 - 1) = 6;
 *
 */
public class _042 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    /**
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
