package yearof2017;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description: 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 */
public class 好未来_求和 {
    static int N = 0;
    static int M = 0;
    static int ans = 0;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();
        dfs(1, 0);
    }

    public static void dfs(int index, int sum) {
        if (sum > M) return;
        if (sum == M) {
            // 打印出结果
            for (int i = 0; i < stack.size(); i++) {
                if (i != stack.size() - 1) {
                    System.out.print(stack.get(i) + " ");
                } else {
                    System.out.print(stack.get(i));
                }
            }
            System.out.println();
        }

        for (int i = index; i <= N; i++) {
            stack.push(i);
            dfs(i + 1, sum + i);
            stack.pop();
        }
    }

}
