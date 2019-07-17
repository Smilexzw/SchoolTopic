package leetcode;

/**
 * @author: xuzhangwang
 */
public class _101对称二叉树 {

    /**
     * 判断一个树是否为对称二叉树，只要判断两个子树是否相同
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 判断左子树和右子树是否相同
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
