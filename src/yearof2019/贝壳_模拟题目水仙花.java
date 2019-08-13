package yearof2019;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class 贝壳_模拟题目水仙花 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean flag = true;
        for (int i = a; i <= b; i++) {
            int gewei = i % 10;
            int shiwei = (i / 10) % 10;
            int baidwei = i / 100;

            if (i == ((gewei * gewei * gewei) + (shiwei * shiwei * shiwei) + baidwei * baidwei * baidwei)) {
                flag = false;
                System.out.print(i + " ");
            }
        }
        if (flag) {
            System.out.println("no");
        }
    }
}
