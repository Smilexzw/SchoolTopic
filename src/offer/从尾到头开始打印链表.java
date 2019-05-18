package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 从尾到头开始打印链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ArrayList<Integer> res = printListFromTailToHead(node1);
        for (Integer num : res) {
            System.out.print(num + ",");
        }
    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        while (pre != null) {
            res.add(pre.val);
            pre = pre.next;
        }
        return res;
    }
}



