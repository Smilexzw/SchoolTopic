package offer;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class ListNode {
    int val;
    offer.ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }


    /**
     * 打印链表
     */
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
