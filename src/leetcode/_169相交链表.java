package leetcode;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _169相交链表 {
    public static void main(String[] args) {


    }

    // 如果是无环链表相交，最后的位置不一样就代表一定不相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int n = 0;
        while (curA.next != null) {
            n++;
            curA = curA.next;
        }
        while (curB.next != null) {
            n--;
            curB = curB.next;
        }
        if (curA != curB) {
            return null;
        }
        curA = n > 0 ? headA : headB;
        curB = curA == headA ? headB : headA;

        n = Math.abs(n);
        while (n != 0) {
            n--;
            curA = curA.next;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;


    }
}
