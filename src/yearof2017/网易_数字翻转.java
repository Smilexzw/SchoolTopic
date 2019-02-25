package yearof2017;

import java.util.Scanner;


public class 网易_数字翻转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        System.out.println(reverseNum(reverseNum(x) + reverseNum(y)));
    }

    public static int reverseNum(int n) {
        int tmp = 0;
        while (n != 0) {
            tmp = tmp*10 + (n % 10);
            n = n / 10;
        }
        return tmp;
    }
}
