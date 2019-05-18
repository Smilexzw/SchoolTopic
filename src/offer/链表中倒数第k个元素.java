package offer;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 链表中倒数第k个元素 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode res = FindKthToTail(node1, 4);
        System.out.println(res.val);
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null | k < 1) return null;
        ListNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k == 0) {
            return head;
        } else if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            return cur.next;
        } else return null;
    }
}
