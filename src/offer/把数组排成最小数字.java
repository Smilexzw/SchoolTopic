package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 把数组排成最小数字 {
    public static void main(String[] args) {
        int[] arr = {3, 1};
        System.out.println(PrintMinNumber(arr));
    }

    public static String PrintMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = String.valueOf(o1);
                String b = String.valueOf(o2);
                return (a + b).compareTo(b + a);
            }
        });
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
        }
        return res;
    }
}
