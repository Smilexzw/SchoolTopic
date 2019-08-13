package leetcode;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _129求根到叶子节点数字之和 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.left = null;
        node2.right = node4;
        node3.left = null;
        node3.right = null;

        node4.right = node4.left = null;
        int res = sumNumbers(node1);
        System.out.println(res);
    }

    static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int res = 1;
        helper(root, 0);
        return sum;
    }

    private static void helper(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        int k = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += k;
        }
        helper(root.left, k);
        helper(root.right, k);
    }
}
