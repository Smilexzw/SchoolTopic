package yearof2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
 * 输入描述:
 * 输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
 * 下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
 * 输出描述:
 * 输出树的高度，为一个整数
 * 示例1
 * 输入
 * 复制
 * 5
 * 0 1
 * 0 2
 * 1 3
 * 1 4
 * 输出
 * 复制
 * 3
 */
public class 小米_树的高度 {
    // 先用map来模拟二叉树
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 3) {
            System.out.println(0);
        } else {
            // 第一个的位置存放的是父节点的名字
            // 第二个结点存放的是当前结点含有几个的子节点
            Map<Integer, Integer> tree = new HashMap<>();
            int high = 0;
            while (sc.hasNext()) {
                // 当前二叉树是否包含了接下来的父节点
                int parent = sc.nextInt();
                int child = sc.nextInt();
                if (tree.containsKey(parent)) {
                    tree.put(parent, tree.get(tree.get(parent)));
                } else {
                    tree.put(parent, tree.get(parent) + 1);
                }
                tree.put(parent, child);
            }
            System.out.println(high);
        }
    }
}
