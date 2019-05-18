package _316;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1024 - sc.nextInt();
        int ans = 0;
        int tmp = 0;
        List<String> list =new ArrayList<>();
        while (n >= 4) {
            if (n >= 64) {
                tmp = n % 64;
                ans += (n / 64);
                list.add((n / 64)  + " " + 64 );
                n = tmp;


            } else if (n < 64 && n >= 16) {
                tmp = n % 16;
                ans += (n / 16);
                list.add((n / 16)  + " " + 16 );
                n = tmp;

            } else if (n < 16 && n >= 4) {
                tmp = n % 4;
                ans += (n / 4);
                list.add((n / 4)  + " " + 4 );
                n = tmp;

            }
        }
        System.out.println(list.toString());
        System.out.println(n);
        if (n < 4) {
            System.out.println(ans + n);
        } else {
            System.out.println(ans);
        }
    }


}
