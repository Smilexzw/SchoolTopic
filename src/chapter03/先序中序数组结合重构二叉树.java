package chapter03;

import java.util.HashMap;


/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 先序中序数组结合重构二叉树 {
    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        Node root = preInToTree(pre, in);
        分别使用递归与非递归实现二叉树先序中序后序遍历.orderRecur(root);
    }


    /**
     * 先序中序结合创建二叉树
     *
     * @param pre
     * @param in
     * @return
     */
    public static Node preInToTree(int[] pre, int[] in) {
        if (pre == null || in == null) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    public static Node preIn(int[] p, int pi, int pj, int[] n, int ni, int nj,
                             HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }

        Node head = new Node(p[pi]);
        int index = map.get(p[pi]);
        head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
        head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);

        return head;
    }

}
