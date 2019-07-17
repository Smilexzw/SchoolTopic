package offer;


import java.util.*;

/**
 * @author xuzhangwang
 */
public class Zig方式打印二叉树 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node4.right = null;
        node5.left = node5.right = null;
        node6.left = node6.right = null;
        node7.left = node8;
        node7.right = node9;


        ArrayList<ArrayList<Integer>> res = Print(node1);
        for (ArrayList<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(head == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        TreeNode last = head;
        TreeNode nlast = null;
        ArrayList<Integer> list = new ArrayList<>();
        int index = 1;
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
