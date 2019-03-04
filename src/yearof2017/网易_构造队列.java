package yearof2017;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 * while(!Q.empty())              //队列不空，执行循环
 * <p>
 * {
 * <p>
 * int x=Q.front();            //取出当前队头的值x
 * <p>
 * Q.pop();                 //弹出当前队头
 * <p>
 * Q.push(x);               //把x放入队尾
 * <p>
 * x = Q.front();              //取出这时候队头的值
 * <p>
 * printf("%d\n",x);          //输出x
 * <p>
 * Q.pop();                 //弹出这时候的队头
 * <p>
 * }
 * <p>
 * 做取出队头的值操作的时候，并不弹出当前队头。
 * 小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正]
 * 输入描述:
 * 第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。
 * 输出描述:
 * 对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
 * 示例1
 * 输入
 * 复制
 * 4
 * 1
 * 2
 * 3
 * 10
 * 输出
 * 复制
 * 1
 * 2 1
 * 2 1 3
 * 8 1 6 2 10 3 7 4 9 5
 */
public class 网易_构造队列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Queue<Integer> Q = new LinkedList<Integer>();
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            Q.offer(sc.nextInt());
//        }
//        while (!Q.isEmpty())              //队列不空，执行循环
//        {
//            int x = Q.element();            //取出当前队头的值x
//            Q.poll();                 //弹出当前队头
//            Q.offer(x);               //把x放入队尾
//            x = Q.element();              //取出这时候队头的值
//            System.out.print(x);       //输出x
//            Q.poll();                 //弹出这时候的队头
//        }

        // 应该逆向可以将原来的返回出来 例如8 1 6 2 10 3 7 4 9 5， 最后弹出的就是10
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            printDeque(sc.nextInt());
        }
    }


    /**
     * 这里使用逆向的做法和题目反着来就可以的，主要的是要会使用Java的Deque双向队列
     * @param n
     */
    public static void printDeque(int n) {
        Deque<Integer> dq = new LinkedList<Integer>();
        dq.offerLast(n);
        int index = n;
        while (dq.size() != n) {
            int x = dq.getLast();
            dq.pollLast();
            dq.offerFirst(--index);
            dq.offerFirst(x);
        }
       while (!dq.isEmpty()) {
           int x = dq.getFirst();
           if (dq.size() == 1) {
               System.out.print(x);
               break;
           }
           dq.pollFirst();
           System.out.print(x + " ");
       }
        System.out.println();
    }
}
