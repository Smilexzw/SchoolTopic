package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuzhangwang
 */
public class _094二叉树的中序遍历 {
    public static void main(String[] args) {

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }
}
