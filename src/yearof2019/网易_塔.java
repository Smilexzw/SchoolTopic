package yearof2019;

import java.util.*;

/**
 * 题目描述
 小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。
 现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。
 小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取下一块立方体，并把它放到另一座塔上。
 注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。
 现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。
 输入描述:
 第一行两个数n,k (1 <= n <= 100, 0 <= k <= 1000)表示塔的数量以及最多操作的次数。
 第二行n个数，ai(1 <= ai <= 104)表示第i座塔的初始高度。
 输出描述:
 第一行两个数s, m，表示最小的不稳定值和操作次数(m <= k)
 接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。
 示例1
 输入
 复制
 3 2
 5 8 5
 输出
 复制
 0 2
 2 1
 2 3
 * @author xuzhangwang
 * @date 2019/7/25
 */
public class 网易_塔 {
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        // 每次获取最大的和最小进行比较
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(i + 1, arr[i]);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        
        // 对开始转移
        for (int i = 0; i < k; i++) {
            Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
            helper(list);
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void helper(List<Map.Entry<Integer, Integer>> list) {
        int min = list.get(0).getValue();
        int max = list.get(list.size() - 1).getValue();
        result.add(list.get(0).getKey());
        result.add(list.get(list.size() - 1).getKey());
        list.get(0).setValue(min + 1);
        list.get(list.size() - 1).setValue(max - 1);
        
    }
}
