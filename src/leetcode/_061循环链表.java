package leetcode;


import java.util.List;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _061循环链表 {
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
        ListNode res = rotateRight(node1, 2);
        ListNode.print(res);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode tail = null; // 尾指针
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        int loop = len - (k % len);  // 循环次数
        tail = cur;
        cur.next = head;
        cur = head;
        for (int i = 0; i < loop; i++) {
            cur = cur.next;
            tail = tail.next;
        }
        tail.next = null;
        return cur;
    }

}
