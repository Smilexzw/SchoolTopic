package leetcode;

/**
 * 题目找出环形链表中的第一个结点
 *
 * @author: xuzhangwang
 */
public class _142环形链表II {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

}
