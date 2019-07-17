package leetcode;

/**
 * 前缀树
 * @author: xuzhangwang
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) return;
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) return false;

        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    /**
     *  如果trie中有任何以给定前缀开头的单词，则返回
     * Returns if there is any word in the trie that starts with the given prefix.
     *
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        char[] chs = prefix.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return true;
    }

}

class TrieNode {

    /**
     * path表示对有多少个单词共用这个节点
     * end表示有多少个单词以这个节点结尾
     * map是孩子，最多有26个
     *
     */
    public int path;

    public int end;

    public TrieNode[] map;

    public TrieNode() {
        this.path = 0;
        this.end = 0;
        map = new TrieNode[26];
    }
}
