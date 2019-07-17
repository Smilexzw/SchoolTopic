package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: xuzhangwang
 */
public class _103二叉树的锯齿遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    /**
     * 遍历得到锯齿
     * @param res
     * @param root
     */
    private void helper(List<List<Integer>> res, TreeNode root) {
        Queue<TreeNode> quene = new LinkedList<>();
        quene.add(root);
        while (!quene.isEmpty()) {
            // 开始遍历
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : quene) {
                list.add(node.val);
            }
            res.add(new ArrayList<>(list));
            for (TreeNode node : quene) {
                if (node.left != null) {
                    quene.add(node.left);
                }
                if (node.right != null) {
                    quene.add(node.right);
                }
                quene.poll();
            }
        }

    }
}
