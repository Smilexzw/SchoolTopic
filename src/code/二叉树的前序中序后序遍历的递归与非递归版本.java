package code;

/**
 * @author xuzhangwang
 */
public class 二叉树的前序中序后序遍历的递归与非递归版本 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

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

        Node.preOrder(node1);
        System.out.println("===============二叉树前序遍历递归");
        Node.inOrder(node1);
        System.out.println("===============二叉树中序遍历递归");
        Node.posOrder(node1);
        System.out.println("===============二叉树后序遍历递归");


        System.out.println("===============================");
        Node.preOrderUn(node1);
        Node.inOrderUn(node1);
        Node.posOrderUn(node1);
    }
}
