package leetcode;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther: xuzhangwang
 * @Description:106. 从中序与后序遍历序列构造二叉树
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (43)
 * 题解
 * 提交记录
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class _106中序后序结合构建二叉树 {
    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] pos = {9,15,7,20,3};
        // 思路后序的最后一个位置一定的是根结点
        TreeNode root = buildTree(in, pos);
        TreePrint.orderRecur(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 ||
                postorder.length == 0 || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(inorder, postorder, map);
        return root;
    }

    private static TreeNode helper(int[] inorder, int[] postorder, HashMap<Integer, Integer> map) {
        // 1. 确定根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int index = map.get(postorder[postorder.length - 1]);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));

        return root;
    }


}
