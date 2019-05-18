package year2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_红与绿 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.nextLine().toCharArray();
        int r = 0;
        int g = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'R') {
                r++;
            }
            if (c[i] == 'G') {
                g++;
            }
        }

        // 算出r前面都有多少个红色

        int R = 0;

        for (int i = 0; i < r; i++) {
            if (c[i] == 'R') {
                R++;
            }
        }
        if (R == 0) {
            System.out.println(r * 2);
        }  else{
            System.out.println((r - R) * 2);
        }
    }


}
