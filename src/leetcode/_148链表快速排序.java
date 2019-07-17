package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xuzhangwang
 */
public class _148链表快速排序 {
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

        ListNode res = sortList1(node1);
        ListNode.print(res);
    }

    /**
     * 对链表进行排序,第一种方法是最简单的，就是将数据转换成为list之后在重新一次循环
     * 时间复杂度为2n + nlong(这个部分是list的排序) 空间复杂度为n，主要是产生了n长度的list列表
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        System.out.println(list.toString());
        System.out.println(head.val);

        // 在将之前的重新复制
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int index = 0;
        while (head != null) {
            head.val = list.get(index++);
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * 使用快速排序进行链表的划分
     * @param head
     * @return
     */
    public static ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        quickSort(head, null);

        return head;
    }

    /**
     * 快速排序，基于快速排序的思想
     * 第一: 需要取得最后一个元素作为主元，在数组中可以直接访问到最后一个元素，但是在单链表中，我们需要先遍历一边链表才能访问到最后一个元素。
     * 第二，在数组中，利用主元将数组划分为两个部分之后，我们可以用下标递归调用，但是在链表中，我们改用头指针和尾指针来标识左右两个部分。如下图所示，左半部分头指针head，尾指针为p1，
     * @param head
     * @param end
     */
    private static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = helper(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    /**
     * 调整链表中的顺序
     * @param head
     * @param end
     */
    private static ListNode helper(ListNode head, ListNode end) {
        ListNode p1 = head;
        ListNode p2 = head.next;

        // 走到末尾停止
        while (p2 != end) {
            if (p2.val < head.val) {
                p1 = p1.next;

                int t = p1.val;
                p1.val = p2.val;
                p2.val = t;
            }
            p2 = p2.next;
        }

        // 当有序的时候不交换p1和key的值
        if (p1 != head) {
            int t = p1.val;
            p1.val = head.val;
            head.val = t;
        }
        return p1;
    }
}
