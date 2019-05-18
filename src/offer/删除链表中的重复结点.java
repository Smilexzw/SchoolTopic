//package offer;
//
//import java.util.HashSet;
//
///**
// * @Auther: xuzhangwang
// * @Description:
// */
//public class 删除链表中的重复结点 {
//    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(4);
//        ListNode node7 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = null;
//
//        ListNode head = deleteDuplication(node1);
//        ListNode.printListNode(head);
//    }
//
//
//    public static ListNode deleteDuplication(ListNode pHead) {
//        if (pHead == null) return null;
//
//        ListNode pre = pHead;
//        ListNode cur = pHead.next;
//
//        while (cur != null) {
//            if (cur.val != pre.val) {
//                pre = pre.next;
//            } else {
//
//            }
//        }
//    }
//
//}
