package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class _5030节点与其祖先之间的最大差值 {
    static int ret = 0;
    static Stack<Integer> stack = new Stack<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node1= new TreeNode(8);
        TreeNode node2= new TreeNode(3);
        TreeNode node3= new TreeNode(10);
        TreeNode node4= new TreeNode(1);
        TreeNode node5= new TreeNode(6);
        TreeNode node6= new TreeNode(14);
        TreeNode node7= new TreeNode(4);
        TreeNode node8= new TreeNode(7);
        TreeNode node9= new TreeNode(13);



        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = null;
        node3.right = node6;

        node4.left = null;
        node4.right = null;

        node5.left = node7;
        node5.right = node8;

        node6.left = node8;
        node6.right = null;

        node7.left = null;
        node7.right = null;

        node8.left = null;
        node8.right = null;

        node9.left = null;
        node9.right = null;


        int res = maxAncestorDiff(node1);
        System.out.println(res);

    }

    /**
     * 思路找出左子树的最大值和
     *
     * @param root
     * @return
     */
    public static int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        go(root);
        return ret;
    }

    private static void go(TreeNode root) {
        if (root == null) {
            return;
        }
//        for (Integer v : stack) {
//            ret = Math.max(ret, Math.abs(root.val - v));
//        }

        for (Integer v : list) {
            ret = Math.max(ret, Math.abs(root.val - v));
        }
        list.add(root.val);
        stack.push(root.val);
        go(root.left);
        go(root.right);
        stack.pop();
        list.remove(list.size() - 1);
    }
}

