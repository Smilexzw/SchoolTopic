package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuzhangwang
 */
public class _145二叉树的后续遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    /**
     * 后续遍历(左右根)
     * @param res
     * @param root
     */
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }


}
