package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 手链问题 {
    static int m;
    static int n;
    static int c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        int[][] nums_color = new int[n][c];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < tmp; j++) {
                int num = sc.nextInt();
                nums_color[i][num - 1] = num;
            }
        }


        int ans = 0;
        for (int j = 0; j < nums_color[0].length; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums_color.length; i++) {
                    list.add(nums_color[i][j]);
            }
            if (!check(list)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean check(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < m; j++) {
                if (list.get(i) == 0) continue;
                int start = list.get(i);
                int end = (list.get((i  + j)  % n));
                if (Math.abs(start - end) == 0) return false;
            }


        }
        return true;

    }
}
