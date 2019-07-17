package leetcode;

import java.util.List;

/**
 * @author xuzhangwang
 */
public class _143重排链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        reorderList(node1);
    }


    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        /* 思路: 找到链表的中心位置，将链表一分为二，然后将后半段的链表反转，之后在合并两个链表 */

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        p2 = p1.next;
        p1.next = null;
        p1 = head;

        // 开始反转后半链表
        ListNode next = null;
        ListNode pre = null;
        while (p2 != null) {
            next = p2.next;
            p2.next = pre;
            pre = p2;
            p2 = next;
        }
        p2 = pre;

        // 合并两个链表使用非递归的版本
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (p1 != null && p2 != null) { // 因为p2一直比p1短，所以只要p2为空完成合并
            cur.next = p1;
            p1 = p1.next;
            cur = cur.next;

            cur.next = p2;
            p2 = p2.next;
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        ListNode.print(dummy.next);
    }
}
