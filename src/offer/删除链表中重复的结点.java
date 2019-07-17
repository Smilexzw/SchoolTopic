package offer;

import java.util.List;

/**
 * 描述： 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不再保留，返回链表的头结点
 * 例如
 * 1->2->2->3->3>4->5
 * 删除之后的为
 * 1 -> 4  -> 5
 * @author xuzhangwang
 */
public class 删除链表中重复的结点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode.printListNode(node1);

        ListNode res = deleteDuplication(node1);
        System.out.println("=====================");
        ListNode.printListNode(res);
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        // 备用头结点，因为头结点可能也会被删除
        ListNode first = new ListNode(-1);

        first.next = pHead;
        ListNode cur = pHead;
        // 前结点
        ListNode pre = first;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                // 两个结点相等，就开始删除cur
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return first.next;
    }
}


