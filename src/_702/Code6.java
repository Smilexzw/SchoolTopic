package _702;

import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class Code6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        int sum = 1024 - N;

        count += (sum / 64);
        sum %= 64;

        count += (sum / 16);
        sum %= 16;

        count += (sum / 4);
        sum %= 4;

        count += sum;
        System.out.println(count);
    }
}
