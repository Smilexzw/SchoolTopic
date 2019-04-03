package leetcode;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description: 1030. 链表中的下一个更大节点  显示英文描述
 * 用户通过次数 182
 * 用户尝试次数 335
 * 通过次数 184
 * 提交次数 748
 * 题目难度 Medium
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * <p>
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i)
 * 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * <p>
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * <p>
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * <p>
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 * <p>
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 */
public class _1030 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        nextLargerNodes2(node1);
    }

    public static int[] nextLargerNodes(ListNode head) {
        if (head.next == null) return new int[]{0};
        List<Integer> list = new ArrayList<>();
        Queue<ListNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            ListNode tmp = node;
            int val = node.val;
            boolean exist = false;
            while (tmp.next != null) {
                ListNode next = tmp.next;
                if (next.val > val) {
                    list.add(next.val);
                    exist = true;
                    break;
                }
                tmp = next;
            }
            if (!exist) {
                list.add(0);
            }
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    public static int[] nextLargerNodes2(ListNode head) {
        int a[] = new int[100000];

        int g = 0;

        ListNode p = head;

        while (p != null) {
            a[g++] = p.val;
            p = p.next;
        }

        int res[] = new int[g];

        for (int i = 0; i < g; ++i) {

            for (int j = i + 1; j < g; ++j) {
                if (a[j] > a[i]) {
                    res[i] = a[j];
                    break;
                }
            }

        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}