package leetcode;

/**
 * 平衡二叉树（ALV）的定义要么一个树为空，要么任何一个结点的左右子树的高度差都不能超过1
 * @author: xuzhangwang
 */
public class _110判断一棵树是否为平衡而二叉树 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = null;
        node3.right = null;

        node4.left = node6;
        node4.right = node7;

        node5.left = null;
        node5.right = null;

        node6.left = null;
        node6.right = null;

        node7.left = null;
        node7.right = null;

        boolean res = isBalanced(node1);
        System.out.println(res);
    }

    /**
     * 思路： 先判断左子树时候为平衡二叉树，如果左子树不是平衡二叉树，直接返回，如需遍历右子树
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <= 1;
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        // 返回最大一边
        return left > right ? (left + 1) : (right + 1);
    }

}
