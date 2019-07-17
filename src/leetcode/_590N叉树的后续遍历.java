package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuzhangwang
 */
public class _590N叉树的后续遍历 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    /**
     * n叉树的后序遍历
     * @param res
     * @param root
     */
    private void helper(List<Integer> res, Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            helper(res, child);
        }
        res.add(root.val);
    }


}
