package yearof2017;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 * {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 * 现在给出一个数字序列，允许使用一种转换操作：
 * 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 * 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 * 输入描述:
 * 输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50) 第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
 * 输出描述:
 * 输出一个数，表示最少需要的转换次数
 * 示例1
 * 输入
 * 复制
 * 4 1 1 1 3
 * 输出
 * 复制
 * 2
 */
public class 网易_回文序列 {
    // 吐槽下牛客题目，上面的格式真的无语
    // 解题思路，从两边开始计算，如果左边等于右边就删除，不等于就进行操作，由于要在两边进行数据的删除就需要使用到的是双向队列
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(sc.nextInt());
        }
        int start = 0;
        int end = deque.size() - 1;
        int ans = 0;
        while(start < end) {
            int l = deque.getFirst();
            int r = deque.getLast();
            if (l == r) {
                deque.pollFirst();
                deque.pollLast();
                start = 0;
                end = deque.size() - 1;
                if (deque.size() != 0) {
                    l = deque.getFirst();
                    r = deque.getLast();
                }

            } else if (l > r){
                // 左边的更大 4 1 1 1 3
                while (l > r && deque.size() != 1) {
                    deque.pollLast();
                    r += deque.getLast();
                    deque.pollLast();
                    deque.addLast(r);
                    ans++;
                }
                end = deque.size() - 1;
            } else {
                // 右边的更大 3 1 1 1 4
                while (l < r && deque.size() != 1) {
                    deque.pollFirst();
                    l += deque.getFirst();
                    deque.pollFirst();
                    deque.addFirst(l);
                    ans++;
                }
                start = 0;
            }
        }
        System.out.println(ans);



    }
}
