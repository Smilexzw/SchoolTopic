package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description:题目描述
 */
public class _105从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 8, 9, 3, 6, 7};
        int[] in = {4, 2, 8, 5, 9, 1, 6, 3, 7};
        TreeNode root = buildTree(pre, in);
        TreePrint.orderRecur(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0
                || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        // 1. 确定根节点
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0; i < preorder.length; ++i) {
            if (preorder[0] == inorder[i]) {
                // 2. 中序根节点的左边为左子树，进入递归构建子树
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + i), Arrays.copyOfRange(inorder, 0, i));
                // 3. 中序根节点的右边为右子树，进入递归构建子树
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }


        return root;
    }


}
