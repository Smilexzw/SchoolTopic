package yearof2017;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description: 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。
 * 如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
 * 输入描述:
 * 第一行输入一个正整数n(n ≤ 1000)
 * 第二行为n个数正整数xi(xi ≤ 1000)
 * 输出描述:
 * 输出可以产生的幸运的袋子数
 * 示例1
 * 输入
 * 复制
 * 3
 * 1 1 1
 * 输出
 * 复制
 * 2
 */
public class 网易_幸运的袋子 {
    public static void main(String[] args) {
        // 、着很显然是一个全组合的问题
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int nbit = 1 << n;
        for (int i = 0; i < nbit; i++) {
            String sb = "";
            int add = 0;
            int mult = 1;
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j;
                if ((tmp & i) != 0) {
                    add += arr[j];
                    mult *= arr[j];
                    sb += arr[j];
                }
            }
            if (add > mult) {
                set.add(sb.toString());
            }

        }
        // 因为题目要求是不去区分球的位置的
        List<String> list = new ArrayList<>(set);
        Set<String> result = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuffer sb = new StringBuffer();
            char[] chars = list.get(i).toCharArray();
            Arrays.sort(chars);
            sb.append(chars);
            result.add(sb.toString());
        }


        // 以上的解题的结果是正确的，但是时间复杂度太高，
        System.out.println(result.size());
    }
}
