package offer;

import java.util.ArrayList;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 *
 * @author: xuzhangwang
 */
public class 二叉树的镜像 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;

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

        Mirror(node1);

        ArrayList<Integer> res = TreeNode.PrintFromTopToBottom(node1);

        System.out.println(res);
    }

    /**
     * 直接开始交换
     * @param root
     */
    public static void Mirror(TreeNode root) {
        if (root == null) return;
        helper(root);
        Mirror(root.left);
        Mirror(root.right);

    }

    private static void helper(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}
