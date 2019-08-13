package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    /**
     *
     *  System.out.print("层序遍历");
     Queue<Node> queue = new LinkedList<>();
     queue.add(head);
     while (!queue.isEmpty()) {
     head = queue.poll();
     System.out.print(head.value + " ");
     if (head.left != null) {
     queue.add(head.left);
     }
     if (head.right != null) {
     queue.add(head.right);
     }
     }
     * 根据根节点打印树
     * @param root
     */
    public static void print(TreeNode root) {
        System.out.println("层序打印");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }
}

