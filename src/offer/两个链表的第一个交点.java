package offer;

/**
 * 输入两个链表，找出他们的第一个公共节点
 * @author xuzhangwang
 */
public class 两个链表的第一个交点 {
    public static ListNode FindFirstCommonNode(ListNode p, ListNode q) {
        while (q != null && p != null) {
            if (q == p) {
                return q;
            } else {
                q = q.next;
                p = p.next;
            }
        }
        return null;
    }


    public static void main(String[] args) {

    }
}
