package leetcode;

/**
 * 思路：使用快慢指针
 * @author: xuzhangwang
 */
public class _141环形链表 {
    public static void main(String[] args) {

    }


    /**
     * 使用快慢指针进行， slow每次只走一个，fast每次走两个，如果相遇则一定有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            // 如果出现【1】的这种情况
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }


        }
    }
}
