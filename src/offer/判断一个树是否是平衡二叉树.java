package offer;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 判断一个树是否是平衡二叉树 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = null;

        node2.left = node4;
        node2.right = node5;

        node3.left = null;
        node3.right = null;

        node4.left = null;
        node4.right = null;

        node5.left = null;
        node5.right = null;

//        node6.left = null;
//        node6.right = null;
        boolean res = IsBalanced_Solution(node1);
        System.out.println(res);

    }

    /*
        平衡二叉树的定义: 要么是一个空树，要么任何一个结点的左右子树高度差的绝对值不能超过1.
     */
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int res = helper(root);
        return res == -1 ? false : true;
    }

    /**
     * 求出左右子树差的高度
     * @param root
     * @return
     */
    private static int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
