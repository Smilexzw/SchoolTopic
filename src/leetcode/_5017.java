package leetcode;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;

/**
 * @Auther: xuzhangwang
 * @Description:5017. 从根到叶的二进制数之和  显示英文描述
 * 用户通过次数 267
 * 用户尝试次数 386
 * 通过次数 269
 * 提交次数 1279
 * 题目难度 Easy
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 以 10^9 + 7 为模，返回这些数字之和。

 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 */
public class _5017 {
    static int res = 0;
    public static void main(String[] args) {
        Treenode root = new Treenode(1);
        Treenode node2 = new Treenode(0);
        Treenode node3 = new Treenode(1);
        Treenode node4 = new Treenode(0);
        Treenode node5 = new Treenode(1);
        Treenode node6 = new Treenode(0);
        Treenode node7 = new Treenode(1);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;
        node7.left = null;
        node7.right = null;
        int sum = sumRootToLeaf(root);
        System.out.println(sum);
    }
    public static int sumRootToLeaf(Treenode root) {
        if (root == null) return 0;
        go(root, 0);
        return res;
    }


    public static void go(Treenode r, int v) {
        int cur = 2 * v + r.val;
        cur %= 1000000007;
        if (r.left == null && r.right == null) {
            res += cur;
            res %= 1000000007;
            return;
        }
        // 如果还有孩子结点就递归孩子结点
        if (r.left != null) {
            go(r.left, cur);
        }

        if (r.right != null) {
            go(r.right, cur);
        }
    }
}

class Treenode {
      int val;
      Treenode left;
      Treenode right;
      Treenode(int x) { val = x; }
}
