package offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @author: xuzhangwang
 */
public class 二叉树中的和为某一个值的路劲 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = null;

        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;

        int target = 22;

        ArrayList<ArrayList<Integer>> res = FindPath(node1, target);
        for (ArrayList<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        helper(root, res, target, new ArrayList<Integer>());
        return res;
    }

    private static void helper(TreeNode node, ArrayList<ArrayList<Integer>> res, int target, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        target -= node.val;

        // 一直要到叶节点为止
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
//            return;
        } else {
            helper(node.left, res, target, list);
            helper(node.right, res, target, list);
        }
        // 开始回溯
        list.remove(list.size() - 1);
        target += node.val;
    }
}
