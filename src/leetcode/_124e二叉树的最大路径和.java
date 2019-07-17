package leetcode;

/**
 * @author: xuzhangwang
 */
public class _124e二叉树的最大路径和 {

    public static int res;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(-2);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right  = node5;

        node4.left = node6;
        node4.right = null;

        node5.left = node5.right = null;

        node6.left = node6.right = null;

        maxPathSum(node1);

        System.out.println(res);
    }


    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    public static int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
