package yearof2017;

import java.util.Scanner;

public class 网易_计算糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        int A = 0, B = 0, C = 0;
        // 0 -1 3 5 可能出现的问题就是 (0+3) / 2 = 1 但是这个不会是解
        A = (x1 + x3) / 2;
        B = (x2 + x4) / 2;
        C = (x4 - x2) / 2;
        if (A - B != x1) {
            System.out.println("No");
        } else if (B - C != x2) {
            System.out.println("No");
        } else if (A + B != x3) {
            System.out.println("No");
        } else if (B + C != x4) {
            System.out.println("No");
        } else {
            System.out.println(A + " " + B + " " + C);
        }

    }
}

