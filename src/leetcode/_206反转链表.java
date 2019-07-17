package leetcode;

/**
 * @author: xuzhangwang
 */
public class _206反转链表 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
