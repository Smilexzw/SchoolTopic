package yearof2017;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description: 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 * 输入描述:
 * 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 * 输出描述:
 * 每组数据输出一个表示最大的整数。
 * 示例1
 * 输入
 * 复制
 * 2
 * 12 123
 * 4
 * 7 13 4 246
 * 输出
 * 复制
 * 12312
 * 7424613
 */
public class 猪八戒_数串 {

    // 使用Comparator完成自定义的排序
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            Collections.sort(list, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1 = String.valueOf(o1);
                    String s2 = String.valueOf(o2);
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }

}
