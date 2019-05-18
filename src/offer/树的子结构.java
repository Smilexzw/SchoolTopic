package offer;

/**
 * @author: xuzhangwang
 */
public class 树的子结构 {
    public static void main(String[] args) {

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        // 判断第一课数目是否，子子树是否相等
        return helper(root1, root2) || helper(root1.left, root2) || helper(root1.right, root2);
    }

    /**
     * 判断当前子树是否相等
     * @param root1 root1是父亲树木
     * @param root2 root2是孩子树木
     * @return
     */
    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;

        // 判断的当前的结点的孩子树木是否相等
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}
