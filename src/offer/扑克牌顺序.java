package offer;

import java.util.Arrays;

/**
 * @author: xuzhangwang
 */
public class 扑克牌顺序 {
    public static void main(String[] args) {
        int[] num = {1, 2, 4, 6, 7};
        boolean res = isContinuous(num);
        System.out.println(res);
    }

    public static boolean isContinuous(int[] num) {
        if (num == null || num.length < 5) return false;

        // 统计癞子的数目
        int cnt = 0;
        for (int i : num) {
            if (i == 0) {
                cnt++;
            }
        }
        Arrays.sort(num);

        // 使用癞子来补齐
        for (int i = cnt; i < num.length - 1; i++) {
            if (num[i] == num[i + 1]) {
                return false;
            }

            cnt -= num[i + 1] - num[i] - 1;
        }
        return cnt >= 0;
    }
}
