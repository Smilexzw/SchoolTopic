package year2018;

import java.util.*;

/**
 * 题目描述
 * 输入一个字符串，输出该字符串中相邻字符的所有组合。
 * 举个例子，如果输入abc，它的组合有a、b、c、ab、bc、abc。
 * （注意：输出的组合需要去重）（40分）
 * 输入描述:
 * 一个字符串
 * 输出描述:
 * 一行，每个组合以空格分隔，相同长度的组合需要以字典序排序，且去重。
 * 示例1
 * 输入
 * 复制
 * bac
 * 输出
 * 复制
 * a b c ac ba bac
 *
 * @author: xuzhangwang
 */
public class 唯品会_字符串组合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        sc.close();

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= c.length; i++) {
            for (int j = 0; j < i; j++) {
//                if (j + i > c.length) {
//                    set.add(str.substring(j, str.length()));
//                } else {
//                    set.add(str.substring(j, j + i));
//                }
                set.add(str.substring(j, i));
            }
        }
        List<String> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return  o1.length() - o2.length();
                }
            }
        });


        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


    }
}
