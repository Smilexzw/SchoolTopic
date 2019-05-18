package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description: 104. 二叉树的最大深度
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (173)
 * 题解
 * 提交记录
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class _104e二叉树的最大深度 {
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

        int max = maxDepth(root);
        System.out.println(max);
    }

    // 二叉树的最大深度
    public static int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//
//        return left > right ? (left + 1) : (right + 1);
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
