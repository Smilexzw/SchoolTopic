package leetcode;

import java.util.List;

/**
 * N叉树
 *
 * @author: xuzhangwang
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
