package code;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class 排序组合红黑球 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = (int) Math.pow(2, n);
        int t = (n - 2) * 2;
        int res = sum - t;
        System.out.println(res);
    }


}
