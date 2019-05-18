package offer;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = NumberOf1(n);
        System.out.println(res);
    }

    /*
        第一种方法最复杂的情况下要经过32次循环
        第二种方法只与1的个数有关
     */
    public static int NumberOf1(int n) {

//        int res = 0;
//        while (n !=0 ) {
//            res += n & 1;
//            n >>>= 1; // 无符号右移
//        }
//        return res;

        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
