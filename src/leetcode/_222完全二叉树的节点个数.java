package leetcode;

import java.util.Scanner;

/**
 * 给出一个完全二叉树，求出该树的节点个数。

 说明：

 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

 示例:

 输入:
 1
 / \
 2   3
 / \  /
 4  5 6

 输出: 6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/8/12
 */
public class _222完全二叉树的节点个数 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = null;

        node4.left = node4.right = null;
        node5.left = node5.right = null;
        node6.left = node6.right = null;

        int res = countNodes(node1);
        System.out.println(res);
    }


    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode cur = root;
        int index = 0;
        while (cur.left != null) {
            cur = cur.left;
            index++;
        }
        int res = 0;
        return index;
    }
}
