package yearof2019;

import java.util.List;

/**
 * @author: xuzhangwang
 */
public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);

        ListNode lode1 = new ListNode(1);
        ListNode lode2 = new ListNode(2);
        ListNode lode3 = new ListNode(1);
        ListNode lode4 = new ListNode(2);
        ListNode lode5 = new ListNode(1);
        ListNode lode6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        lode1.next = lode2;
        lode2.next = node3;
        lode3.next = null;



        ListNode r;

        ListNode C = new ListNode(0);
        C = node1;
        C.next = null;

        r = C;

        r.next = node2;
    }
}
