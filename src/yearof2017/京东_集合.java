package yearof2017;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素。
 * 输入描述:
 * 每组输入数据分为三行,第一行有两个数字n,m(0 ≤ n,m ≤ 10000)，分别表示集合A和集合B的元素个数。
 * 后两行分别表示集合A和集合B。每个元素为不超过int范围的整数,每个元素之间有个空格隔开。
 * 输出描述:
 * 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开,行末无空格。
 */
public class 京东_集合 {
    public static void main(String[] args) {
        // 大家注意 他给的样例中存在本身相等的情况，做错的朋友要记得处理一下
        // 所以大家要处理相同的值
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        Set<Integer> set = new HashSet<>();
        while (sc.hasNext()) {
            int one = sc.nextInt();
            int two = sc.nextInt();
            for (int i = 0; i < one + two; i++) {
                set.add(sc.nextInt());
            }
        }
        List list = new ArrayList(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }

}
