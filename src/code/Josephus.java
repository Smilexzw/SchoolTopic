package code;

import java.util.ArrayList;

/**
 * @Auther: xuzhangwang
 * @Description: 约瑟环问题
 */
public class Josephus {
    public static void main(String[] args) {
        int n = 13;
        int k = 3;
        int last;
        // 使用递归进行解决
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        last = getLast(list, k, 0);    //从下标为0开始报数，
        System.out.println(last);

    }

    public static int getLast(ArrayList<Integer> list, int k, int m) {
        int last = -1;    //用来放置最后一个人的编号
        int index = -1;    //用来放置当前一轮被移除的人的下标
        if (list.size() == 1) { // 如果集合内只剩一个元素，则直接返回该元素作为结果
            last = list.get(0);
        } else {
            index = (m + k - 1) % list.size(); // 求出当前一轮被移除的人的下标
/*	System.out.println("当前集合内的元素为：" + list.toString());
System.out.println("从" + list.get(m) + "开始报数,被移除的是:"
+ list.get(index));*/
            list.remove(index); // 将该人移除
            m = index % list.size(); // 求出新一轮报数时开始的人在新集合里的下标
            last = getLast(list, k, m); // 使用剩余的集合和m的位置重新开始下一轮计算
        }
        return last;
    }
}