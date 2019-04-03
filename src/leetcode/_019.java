package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xuzhangwang
 * @Description:19. 删除链表的倒数第N个节点
 * 题目描述
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 是
 * <p>
 * 否
 * 贡献者
 * LeetCode
 */
public class _019 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        node1.next = null;
        ListNode head = removeNthFromEnd(node1, 1);
        print(head);

    }

    private static void print(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.print(head.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用map进行存放每一个结点的位置，找到尧删除的结点之后，将结点连接到下下个结点
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 1;
        ListNode temp = head;
        while (temp.next != null) {
            map.put(index++, temp);
            temp = temp.next;
        }
        map.put(index, temp);
        int size = map.size();
        if (size == 1)
            return null;
        if (n == 1) {
            map.get(size - 1).next = null;
        } else if (n == size) {
            head = head.next;
        } else {
            map.get(size - n).next = map.get(size - n + 2);
        }
        return head;
    }


}
