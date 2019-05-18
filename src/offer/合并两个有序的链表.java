package offer;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 合并两个有序的链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        ListNode head = Merge(l1, n1);
        ListNode.printListNode(head);
    }

    public static ListNode Merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = Merge(l1.next, l2);
            return l1;
        } else {
            l2.next = Merge(l1, l2.next);
            return l2;
        }
    }
}
