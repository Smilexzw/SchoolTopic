package leetcode;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: xuzhangwang
 */
public class TrieTest extends TestCase {

    Trie trie = new Trie();

    @Before
    public void testInsert() throws Exception {

    }

    @Test
    public void testSearch() throws Exception {
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("abd");
        trie.insert("b");
        trie.insert("bcd");
        trie.insert("efg");
        trie.insert("hik");
        boolean res = trie.search("c");
        System.out.println(res);
    }

}