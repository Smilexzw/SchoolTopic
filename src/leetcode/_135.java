package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description:135. 分发糖果
 * 题目描述
 * 评论 (21)
 * 题解
 * 提交记录
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class _135 {
    public static void main(String[] args) {
        int[] ratings = {1,2, 2};
        int res = candy(ratings);
        System.out.println(res);
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        // 两次for循环
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1); // 每个小朋友都由至少由一个糖果
        for (int i = 1; i < candy.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }
        int res = 0;
        for (int num : candy) {
            res += num;
        }
        return res;
    }
}
