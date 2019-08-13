package yearof2019;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/7/24
 */
public class 网易_数对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i % j) >= k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
