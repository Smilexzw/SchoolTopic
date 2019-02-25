package yearof2017;

import java.math.BigInteger;
import java.util.Scanner;


public class 滴滴_末尾0的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger bi = new BigInteger(String.valueOf(n));
        while (n-1 != 0) {
            bi = bi.multiply(BigInteger.valueOf(n - 1));
            n--;
        }
        // 统计末尾有几个0就用除法取余
        int total = 0;
        while (bi != BigInteger.valueOf(0)) {
            if (bi.remainder(BigInteger.valueOf(10)) == BigInteger.valueOf(0)) {
                total++;
                bi = bi.divide(BigInteger.valueOf(10));
            } else {
                break;
            }
        }
        System.out.println(total);
    }
}

