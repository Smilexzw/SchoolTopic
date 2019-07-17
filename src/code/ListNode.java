package code;

import java.util.List;

/**
 * 链表的数据结构
 * @author xuzhangwang
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }


    /**
     * 单链表打印数据
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
