package leetcode;

import java.util.*;

/**
 * @author xuzhangwang
 * @date 2019/7/29
 */
public class _013二叉树的锯齿形层次遍历 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = null;
        treeNode2.right = null;
        treeNode3.left = null;
        treeNode3.right = null;

        List<List<Integer>> res = zigzagLevelOrder(treeNode1);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        TreeNode nlast = null;
        List<Integer> list = new ArrayList<>();
        int index = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
                nlast = root.left;
            }
            if(root.right != null) {
                queue.add(root.right);
                nlast = root.right;
            }
            if (root == last && !queue.isEmpty()) {
                if (index % 2 == 0) {
                    Collections.reverse(list);
                }
                index++;
                res.add(list);
                list = new ArrayList<>();
                last = nlast;
            }
        }
        if (res.size() % 2 == 1) {
            Collections.reverse(list);
        }
        res.add(list);
        return res;
    }
}
