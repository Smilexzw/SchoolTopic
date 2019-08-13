package yearof2019;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/7/24
 */
public class 网易_被3整除 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        // 尾数为0 7 8的是一定不行的
        // 枚举出前n个每3个就有两个是 而且规律是0 1 1 0 1 1 0 1 1 0 1 1 0 1 1
        // 并且当前的数字为( (i + 1) * i / 2 ) % 3 == 0
        int count = 0;
        for (int i = l; i <= r; i++) {
            long t = i;
            if((t + 1) * t / 2 % 3 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
