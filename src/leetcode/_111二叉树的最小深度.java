package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class _111二叉树的最小深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        root.left = node2;
        root.right = node3;

        node2.left = null;
        node2.right = null;

        node3.left = node4;
        node3.right = node5;

        node4.left = null;
        node4.right = null;

        node5.left = null;
        node5.right = null;

        int min = minDepth(root);
        System.out.println(min);

    }

    public static int minDepth(TreeNode root) {
       if (root == null) return 0;
       if (root.left == null || root.right == null) {
           return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
       }
       return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
