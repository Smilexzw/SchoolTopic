package _316;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class ValidABC {
    public static void main(String[] args) {
        int a = 0 , b = 0, c= 0 ;
        Scanner sc = new Scanner(System.in);
        try {
            a = Integer.valueOf(sc.next());
            b = Integer.valueOf(sc.next());
            c = Integer.valueOf(sc.next());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("转换错误");
        }

        if (a <= 0) {
            System.out.println("a错误");
            return;
        }
        if (b <= 0) {
            System.out.println("b错误");
            return;
        }
        if (c <= 0) {
            System.out.println("c错误");
            return;
        }


        //判断的是否为三角形的
        if ((a + b > c) && (a + c > b) && (c + b > a)) {
            if (a == b && b == c) {
                System.out.println("等边三角形");
            } else if (a == b || b == c || c == a) {
                System.out.println("等腰三角形");
            } else {
                System.out.println("普通三角形");
            }
        }


        if (a + b <= c) {
            System.out.println(a + " + " + b + " <= " + c);
        }

        if (a + c <= b) {
            System.out.println(a + " + " + c + " <= " + b);
        }

        if (c + b <= a) {
            System.out.println(c + " + " + b + " <= " + a);
        }


    }
}
