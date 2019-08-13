package chapter02;

/**
 * @author xuzhangwang
 * @date 2019/8/6
 */
class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public Node(int data, Node next) {
        this.value = data;
        this.next = next;
    }
}
