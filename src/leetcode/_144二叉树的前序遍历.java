package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuzhangwang
 */
public class _144二叉树的前序遍历 {
    public static void main(String[] args) {

    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    /**
     * 前序遍历(根左右)
     * @param res
     * @param root
     */
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
}
