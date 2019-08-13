package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _089格雷编码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> res = grayCode(n);
        System.out.println(res.toString());
    }

    /**
     * 格雷编码的生成过程G(i) = i ^ (i / 2)
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            int t = i ^ (i / 2);
            list.add(t);
        }
        return list;
    }
}
