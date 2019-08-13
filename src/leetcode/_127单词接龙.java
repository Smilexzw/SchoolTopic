package leetcode;

import java.util.*;


/**
 * beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-ladder
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _127单词接龙 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";


        int res = ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }


    /**
     * 分析题目画出图，可以将问题抽象为无权图，每个单词作为节点，差距只有一个字母的两个单词之间连一条边，问题变成起点到终点的最短距离。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        HashMap<String, Integer> map = new HashMap<>(); // 用于储存的已经访问过的节点，并储存到其路径上，相当于BFS算法中的isVisted功能
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = map.get(word); // 记录现在路径的位置
            for (int i = 0; i < word.length(); i++) {
                char[] wordUtil = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (wordUtil[i] == j) continue;
                    wordUtil[i] = j;
                    String temp = new String(wordUtil);
                    if (temp.equals(endWord)) {
                        // 已经处理到最后一个位置
                        return map.get(word) + 1;
                    }
                    // 如果字典中存在相邻节点，并且这个节点并未被访问过
                    if (set.contains(temp) && !map.containsKey(temp)) {
                        map.put(temp, level + 1);
                        queue.add(temp);  // 加入队列以供搜索
                    }
                }
            }
        }
        return 0;
    }
}
