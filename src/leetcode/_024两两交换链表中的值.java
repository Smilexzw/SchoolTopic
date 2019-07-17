package leetcode;

/**
 * @author: xuzhangwang
 */
public class _024两两交换链表中的值 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode head = swapPairs(node1);
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode list1 = new ListNode(0);
        list1.next = head;
        ListNode list2 = list1;
        while (head != null && head.next != null) {
            list2.next = head.next;
            head.next = list2.next.next;
            list2.next.next = head;
            list2 = list2.next.next;
            head = list2.next;
        }
        return list1.next;
    }
}
