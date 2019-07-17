package leetcode;
/**
 *
 * @author xuzhangwang
 */
public class _147对链表进行插入排序 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(60);
        ListNode node2 = new ListNode(71);
        ListNode node3 = new ListNode(49);
        ListNode node4 = new ListNode(11);
        ListNode node5 = new ListNode(24);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(66);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        ListNode res = insertionSortList(node1);
        ListNode.print(res);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode temp = null, pre = null;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                temp = cur.next;
                cur.next = temp.next;
                pre = dummy;
                while (pre.next.val <= temp.val) {
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;
    }
}
