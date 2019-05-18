package code;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class _12选择5 {
    final static int COUNT = 5;

    static char[] array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};

    static LinkedList<char[]> list = new LinkedList<char[]>();

    static int[] indexs = new int[COUNT];

    static int len = array.length;

    public static void main(String[] args) {
        recursionSub(0, -1);
        for (char[] cs : list) {
            System.out.println(Arrays.toString(cs));
        }
    }

    public static void recursionSub(int ind, int start) {
        start++;
        if (start > COUNT - 1) {
            return;
        }
        for (indexs[start] = ind; indexs[start] < len; indexs[start]++) {
            recursionSub(indexs[start] + 1, start);
            if (start == COUNT - 1) {
                char[] temp = new char[COUNT];
                for (int i = COUNT - 1; i >= 0; i--) {
                    temp[start - i] = array[indexs[start - i]];
                }
                list.add(temp);
            }
        }
    }
}
