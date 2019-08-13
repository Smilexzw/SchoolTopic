package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

 说明：
 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

 示例 1:

 输入: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
    2
 输出: 1
 示例 2:

 输入: root = [5,3,6,2,4,null,null,1], k = 3
 5
 / \
 3   6
 / \
 2   4
 /
 1
 输出: 3
 进阶：
 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _230二叉搜索树中第K小的元素 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.left = null;
        node2.right = node4;
        node3.left = null;
        node3.right = null;

        node4.right = node4.left = null;
        kthSmallest(node1, 3);
        System.out.println(list.toString());
    }

    static List<Integer> list = new ArrayList<>();

    /**
     * 二叉搜索树的中序遍历是有序的数组
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 0) {
            return -1;
        }
        inOrder(root);
        if (k > list.size()) {
            return -1;
        }
        return list.get(k - 1);
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
