package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 京东_求幂 {
    public static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= n; l++) {
                        if (Math.pow(i, j) == Math.pow(k, l)) {
                            System.out.println(i +"^" + j + "=" + k +"^" + l);
                        }
                    }
                }
            }
        }


    }


}
