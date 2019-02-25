package yearof2017;

import java.util.Scanner;

public class 好未来_倒置字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i]);
            if (i!=0) {
                System.out.print(" ");
            }
        }

    }
}
