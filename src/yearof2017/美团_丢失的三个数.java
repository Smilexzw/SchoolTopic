package yearof2017;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description: 现在有一个数组，其值为从1到10000的连续增长的数字。
 * 出于某次偶然操作，导致这个数组中丢失了某三个元素，同时顺序被打乱，
 * 现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新数字，
 * 计算其除以7的余数。 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。
 */
public class 美团_丢失的三个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        List<Integer> bigList = new ArrayList<Integer>();
        List<Integer> smallList = new ArrayList<Integer>();
        for (int i = 1; i <= 9997; i++) {
            smallList.add(sc.nextInt());
        }
        sc.close();
        for (int i = 1; i <= 10000; i++) {
            bigList.add(i);
        }
        bigList.removeAll(smallList);
        Collections.sort(bigList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        String str = "";
        for (int i = 0; i < bigList.size(); i++) {
            str += bigList.get(i);
        }
        System.out.println(Integer.valueOf(str) % 7);
    }
}
