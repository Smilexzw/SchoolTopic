package year2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 在英文中,我们会把一些长的名字或者短语进行缩写。例如"looks good to me"缩写为"lgtm",短语中的每个单词的首字母组成缩写。现在给出一个字符串s,字符串s中包括一个或者多个单词,单词之间以空格分割,请输出这个字符串的缩写。
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串中只包括小写字母('a'~'z')和空格。
 * 输出描述:
 * 输出一个字符串,即缩写的结果。
 * 示例1
 * 输入
 * 复制
 * looks good to me
 * 输出
 * 复制
 * lgtm
 *
 * @author: xuzhangwang
 */
public class 网易_缩写 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String res = "";
        for (String str : s) {
            if (str != null) {
                res += (str.charAt(0));
            }
        }
        System.out.println(res);
    }
}
