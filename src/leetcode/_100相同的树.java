package leetcode;



/**
 * @author: xuzhangwang
 */
public class _100相同的树 {

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && q.val == p.val) {
            return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
        } else {
            return false;
        }
    }
}
