package leetcode;

import java.util.Stack;

/**
 * 二叉搜索树（BST）， 二叉搜索树左子树都小于root结点，右子树都大于根节点
 * @author: xuzhangwang
 */
public class _098判断一个树是否为二叉搜索树BST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
//
//        node1.left = node2;
//        node1.right = node3;
//
//        node2.left = null;
//        node2.right = null;
//
//        node3.left = node4;
//        node3.right = node5;
//
//        node4.left = null;
//        node4.right = null;
//        node5.left = null;
//        node5.right = null;


        node1.left = node2;
        node1.right = node3;

        node2.left = null;
        node2.right = null;

        node3.left = null;
        node3.right = null;




        boolean res = isvalidBST(node1);
        System.out.println(res);
    }

    public static boolean isvalidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    /**
     * 不使用递归版本
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            // 先得到所有的左子树
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 中序遍历前一个结点的值大于后一个值
                root = stack.pop();
                if (pre != null && root.val <= pre.val) return false;
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
}
