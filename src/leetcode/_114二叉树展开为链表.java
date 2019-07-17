package leetcode;

/**
 * @author: xuzhangwang
 */
public class _114二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        flatten(node1);

        TreeNode.print(node1);

    }


    /**
     * 将所有的结点全部的连接到右子树
     * @param root
     */
    public static void flatten(TreeNode root) {

        if (root == null) return;

        /**
         * 递归左子树
         */
        if (root.left != null) {
            flatten(root.left);
        }

        /**
         * 递归右子树
         */
        if (root.right != null) {
            flatten(root.right);
        }

        /*
         * 切断其父亲结点与左孩子结点，将原左结点放到右节点
         */
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        /*
         * 将原来的右节点连接到新的右节点的右节点上
         */
        while (root.right != null) {
            root = root.right;
        }

        root.right = temp;
    }
}
