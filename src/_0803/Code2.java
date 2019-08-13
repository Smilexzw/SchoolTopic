package _0803;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/3
 */
public class Code2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) {
                arr[i] = sc.nextInt();
            }
            helper(arr);
        }
    }

    /**
     * 中间的小于两边和
     * @param arr
     */
    private static void helper(int[] arr) {
        boolean[] use = new boolean[arr.length];
        for (int i = 0; i < use.length; i++) {
            use[i] = true;
        }
        if (arr.length < 3) {
            System.out.println("NO");
            return;
        }
        if (arr[0] >= (arr[1] + arr[arr.length - 1])) {
            System.out.println("NO");
            return;
        } else {
            use[0] = use[1] = use[use.length - 1] = false;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] >= (arr[i + 1] + arr[i - 1]) && use[i] && use[i + 1] && use[i - 1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
