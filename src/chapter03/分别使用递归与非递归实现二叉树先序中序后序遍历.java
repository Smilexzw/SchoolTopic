package chapter03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 分别使用递归与非递归实现二叉树先序中序后序遍历 {
    public static void main(String[] args) {
        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);
        Node node1 = new Node(1, node2, node3);

        // ============================== 递归方式

//        preOrderRecur(node1);
//        System.out.println();
//        inOrderRecur(node1);
//        System.out.println();
//        posOrderRecur(node1);

        // =============================== 非递归
//        orderRecur(node1);
//        preOrderUnRecur(node1);
//        System.out.println();
        inOrderUnRecur(node1);

//        posOrderUnRecur(node1);

    }

    /*
        层序遍历, 队列
     */
    public static void orderRecur(Node head) {
        System.out.print("层序遍历");
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
    }

    /*
        递归的先序遍历
     */
    public static void preOrderRecur(Node head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /*
        非递归的先序遍历, 模拟栈
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }


    /*
        递归的中序遍历
     */
    public static void inOrderRecur(Node head) {
        if (head == null) return;
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /*
        非递归的中序遍历
     */
    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            // 当stack为空和cur为空就结束当前的过程
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head  = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    /*
        递归的后序遍历
     */
    public static void posOrderRecur(Node head) {
        if (head == null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /*
        非递归的后序遍历，使用两个栈进行模拟
     */
    public static void posOrderUnRecur(Node head) {
        System.out.print("pos-order: ");
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
                System.out.print(s2.pop().value + " ");
            }
        }
    }

}

class Node {
    public int value;
    public Node left;
    public Node right;


    public Node(int data) {
        this.value = data;
    }

    public Node(int data, Node left, Node right) {
        this.value = data;
        this.left = left;
        this.right = right;
    }
}