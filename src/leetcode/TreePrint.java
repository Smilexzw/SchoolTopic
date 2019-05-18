package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class TreePrint {

    public static void orderRecur(TreeNode head) {
        System.out.print("层序遍历");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.val + " ");
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }
}
