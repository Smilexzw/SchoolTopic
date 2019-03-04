package yearof2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Auther: xuzhangwang
 * @Description: 小易最喜欢的单词
 * 题目描述
小易喜欢的单词具有以下特性：
1.单词每个字母都是大写字母
2.单词没有连续相等的字母
3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。
例如：
小易不喜欢"ABBA"，因为这里有两个连续的'B'
小易不喜欢"THETXH"，因为这里包含子序列"THTH"
小易不喜欢"ABACADA"，因为这里包含子序列"AAAA"
小易喜欢"A","ABA"和"ABCBA"这些单词
给你一个单词，你要回答小易是否会喜欢这个单词（只要不是不喜欢，就是喜欢）。
 */
public class 网易_小易最喜欢的单词 {
    // 字符串的问题直接就使用正则表达式进行匹配
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String word = sc.next();

            if(isAllUpCase(word) && isConEql(word) && isThrEql(word))
                System.out.println("Likes");
            else
                System.out.println("Dislikes");
        }
    }
    //条件1
    public static boolean isAllUpCase(String word){
        return word.matches("[A-Z]+");
    }
    //条件2
    public static boolean isConEql(String word){
        return !word.matches(".*(.)(\\1).*");
    }
    //条件3
    public static boolean isThrEql(String word){
        return !word.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
    }
}
