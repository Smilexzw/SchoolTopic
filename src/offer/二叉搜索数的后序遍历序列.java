package offer;

/**
 * @Auther: xuzhangwang
 * @Description:题目描述 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class 二叉搜索数的后序遍历序列 {
    public static void main(String[] args) {
        int[] arr = {2, 15, 6, 16, 17, 15, 19, 18, 12};
        boolean res = VerifySquenceOfBST(arr);
        System.out.println(res);
    }

    /*
        判断该数组是否是二叉搜索树的后序遍历数组
        二叉搜索树的特点是左子树全部小于根节点
                        右子树全部大于根节点
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return helper(sequence, 0, sequence.length - 1);
    }

    private static boolean helper(int[] s, int start, int root) {
        // 如果出现start大于等于root的情况，说明之前遍历都是正确的，所以这里就返回true
        if (start >= root) return true;

        int i = root;
        while (i > start && s[i - 1] > s[root]) {
            i--;
        }
        for (int j = start; j < i; j++) {
            if (s[j] > s[root]) return false;
        }
        return helper(s, start, i - 1) && helper(s, i, root - 1);
    }
}
