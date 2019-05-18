package _515;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] star = new int[n][2];
        for (int i = 0; i < n; i++) {
            star[i][0] = sc.nextInt();
            star[i][1] = sc.nextInt();
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c =sc.nextInt();
            int d = sc.nextInt();
            int count = 0;
            for (int j = 0; j < n; j++) {
                // 获取当前的星星
                int x = star[j][0];
                int y = star[j][1];
                if (x > c || a < a) continue;
                if (y >d || y < b) continue;
                if ((x >= a && x <= c) && (y >= b && y <= d)) {
                    count++;
                }
            }
            System.out.println(count);
        }
        

    }
}
