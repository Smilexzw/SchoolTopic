package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuzhangwang
 */
public class _113二叉树路径之和II {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        node3.left = node5;
        node3.right = node6;

        node4.left = node7;
        node4.right = node8;

        node6.left = node9;
        node6.right = node10;


        List<List<Integer>> res = pathSum(node1, 22);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }

    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, new ArrayList<Integer>(), root, sum);
        return res;
    }

    private static void helper(List<List<Integer>> res, ArrayList<Integer> list, TreeNode root, int sum) {

        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }

        if (root.left != null) {
            list.add(root.val);
            helper(res, list, root.left, sum - root.val);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            list.add(root.val);
            helper(res, list, root.right, sum - root.val);
            list.remove(list.size() - 1);
        }
    }
}
