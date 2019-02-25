package yearof2017;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 滴滴_进制转化 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        if (M < 0) {
            M = Math.abs(M);
            sb.append("-");
        }

        while (M != 0) {
            stack.push(M % N);
            M = M / N;
        }
        while (!stack.empty()) {
            sb.append(isString(stack.pop()));
        }
        System.out.println(sb.toString());
    }

    public static String isString(int key) {
        if (key >= 9 && key <= 15) {
            switch (key) {
                case 10: if(key == 10) return "A";
                case 11: if(key == 11) return "B";
                case 12: if(key == 12) return "C";
                case 13: if(key == 13) return "D";
                case 14: if(key == 14) return "E";
                case 15: if(key == 15) return "F";
            }
        }
        return String.valueOf(key);
    }
}
