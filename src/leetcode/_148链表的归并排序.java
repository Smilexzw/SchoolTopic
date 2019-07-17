package leetcode;


import java.util.List;

/**
 * @author xuzhangwang
 */
public class _148链表的归并排序 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(60);
        ListNode node2 = new ListNode(71);
        ListNode node3 = new ListNode(49);
        ListNode node4 = new ListNode(11);
        ListNode node5 = new ListNode(24);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(66);
        ListNode node8 = new ListNode(22);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;

        ListNode.print(node1);
//        ListNode res = getMid(node1);
        ListNode res = sortList(node1);
        System.out.println();
        ListNode.print(res);
    }

    /**
     * 采用归并排序
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        // 开始合并
        return megerSosrt(sortList(head), sortList(right));
    }

    /**
     * 获取链表的中间结点,如果是偶数的话就采用中间的第一个
     * @param head
     */
    private static ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 使用快慢指针
        ListNode slow = head;
        ListNode quick = head;
        // 快指针走两步，慢指针走一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     * 归并两个有序的链表的
     * @param l1
     * @param l2
     */
    public static ListNode megerSosrt(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = megerSosrt(l1.next, l2);
            return l1;
        } else {
            l2.next = megerSosrt(l1, l2.next);
            return l2;
        }
    }
}
