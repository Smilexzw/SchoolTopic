package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuzhangwang
 */
public class 二叉树打印成为多行 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node4.right = null;
        node5.left = node5.right = null;
        node6.left = node6.right = null;
        node7.left = node7.right = null;
        print(node1);

        ArrayList<ArrayList<Integer>> res = Print(node1);
        for (ArrayList<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    /**
     * 二叉树的层序遍历
     * @param head
     */
    public static void print(TreeNode head) {
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = head;
        TreeNode nlast = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.val + " ");
            if (head.left != null) {
                queue.add(head.left);
                nlast = head.left;
            }
            if (head.right != null) {
                queue.add(head.right);
                nlast = head.right;
            }

            if (head == last && !queue
                    .isEmpty()) {
                System.out.println();
                last = nlast;
            }
        }
        System.out.println();
    }


    public static ArrayList<ArrayList<Integer>> Print(TreeNode head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = head;
        TreeNode nlast = null;
        queue.offer(head);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            head = queue.poll();
            list.add(head.val);
            if (head.left != null) {
                queue.add(head.left);
                nlast = head.left;
            }
            if (head.right != null) {
                queue.add(head.right);
                nlast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                res.add(list);
                list = new ArrayList<>();
                last = nlast;
            }
        }
        res.add(list);
        return res;
    }
}
