package leetcode;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _235二叉搜索数的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        TreeNode left = lowestCommonAncestor(head.left, o1, o2);
        TreeNode right = lowestCommonAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
}
