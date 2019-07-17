package code;

import java.util.Stack;

/**
 * 二叉树的问题
 * @author xuzhangwang
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }


    /**
     * 前序遍历，前序遍历的规则是根左右
     * @param head
     */
    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    /**
     * 二叉树的中序遍历使用的规则左根右
     * @param head
     */
    public static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }


    /**
     * 二叉树的后序遍历，使用的规则是左右根
     * @param head
     */
    public static void posOrder(Node head) {
        if (head == null) {
            return;
        }
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.val + " ");
    }


    /**
     * 二叉树的前序遍历非递归版本使用的是stack进行模拟
     * @param head
     */
    public static void preOrderUn(Node head) {
        System.out.print("非递归的前序遍历: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }


    /**
     * 二叉树的中序遍历非递归版本
     * @param head
     */
    public static void inOrderUn(Node head) {
        System.out.print("非递归的中序遍历：");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归版本的后序遍历，使用两个栈进行模拟
     * 1、申请一个栈，记为s1，然后将头结点加入到s1
     * 2、从s1中弹出的结点记为cur，依次将cur的左结点和右节点加入到s1中
     * 3、在整个过程中s1弹出的结点就加入到s2中
     * 4、当s1为空，就停止
     * @param head
     */
    public static void posOrderUn(Node head) {
        System.out.print("非递归的后序遍历:");
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);

            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);

                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }

            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }
}