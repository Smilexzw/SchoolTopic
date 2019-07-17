package leetcode;

/**
 * @author: xuzhangwang
 */
public class _023合并k个链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next =node3;
        node3.next = node4;
        node4.next = null;

        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(9);
        node5.next = node6;
        node6.next = node7;
        node7.next = null;


        ListNode node8 = new ListNode(0);
        ListNode node9 = new ListNode(7);
        ListNode node10 = new ListNode(93);

        node8.next = node9;
        node9.next = node10;
        node10.next = null;

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(99);
        ListNode node13 = new ListNode(100);
        node11.next = node12;
        node12.next = node13;
        node13.next = null;

        ListNode[] lists = new ListNode[4];
        lists[0] = node1;
        lists[1] = node5;
        lists[2] = node8;
        lists[3] = node11;

        ListNode head = mergeKLists(lists);
        ListNode.print(head);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists , 0, lists.length - 1);
    }

    private static ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = (hi - lo) / 2 + lo;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
