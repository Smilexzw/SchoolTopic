package chapter02;

/**
 * @author xuzhangwang
 * @date 2019/8/6
 */
public class TestNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        Node cur = node1;
        // 反转链表

        Node head = new Node(-1);
        head.next = node1;
    }
}
