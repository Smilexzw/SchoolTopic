package offer;

/**
 * @author: xuzhangwang
 */
public class 链表中环的入口结点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode res = EntryNodeOfLoop(node1);
        System.out.println(res.val);

    }

    public static ListNode EntryNodeOfLoop(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;   // 如果出现相等就的表示当前已经相遇
            }
        }
        while (head != fast) {
            fast = fast.next;
            head = head.next;
        }
        return head;
    }
}
