package leetcode;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class _102二叉树的层次遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        root.left = node2;
        root.right = node3;

        node2.left = null;
        node2.right = null;

        node3.left = node4;
        node3.right = node5;

        node4.left = null;
        node4.right = null;

        node5.left = null;
        node5.right = null;



//        List<List<Integer>> res = levelOrder(root);
//        for (List<Integer> list : res) {
//            System.out.println(list.toString());
//        }
        ArrayList<Integer> res = PrintFromTopToBottom(root);
        System.out.println(res.toString());
    }


    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            res.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return res;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 如果队列中不为空就继续添加元素
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                list.add(cur.val);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
