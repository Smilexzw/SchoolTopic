package chapter02;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 反转单向和双向链表 {
    public static void main(String[] args) {
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        print(reverseList(node1));

    }

    /**
     * 打印单向链表
     * @param head
     * @return
     */
    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    /*
        反转单向链表, 函数返回的反转之后链表新的头结点
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }





}
