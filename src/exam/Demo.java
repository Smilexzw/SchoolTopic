package exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Demo {
    // 0 石头 1 布 2 剪刀
    // 这道题目可以使用统计来处理

    private static ArrayList<Integer> tmpArr = new ArrayList<>();
    static int[] arr = {0, 1, 2};
    static int[] wom;
    static int ans = 0;
    static int[] Q;
    static int s = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();
        wom = new int[n];
        for (int i = 0; i < n; i++) {
            wom[i] = sc.nextInt();
        }
        repeatableArrangement(n, arr);
        System.out.println(ans);
        System.out.println(getRes(n , s));
    }


    /*
        使用排列组合公式

     */

    public static long f(int num) {
        long res = 1;
        for (int i = num; i > 0; i--) {
            res *= i;
        }
        return res;
    }

    public static long getRes(int n, int s) {
        int a = n - s;
        long res = (long) ((f(n) / (f(s) * f(a)))*Math.pow(2, n - s));
        return res;
    }

    public static void repeatableArrangement(int k, int[] arr) {
        if (k == 1) {
            for (int i = 0; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                check(tmpArr);
                tmpArr.remove(tmpArr.size() - 1); //移除尾部元素
            }
        } else if (k > 1) {
            for (int i = 0; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                repeatableArrangement(k - 1, arr); //不去重
                tmpArr.remove(tmpArr.size() - 1); //移除尾部元素,不能用remove(Object),因为它会移除头部出现的元素，我们这里需要移除的是尾部元素
            }
        } else {
            return;
        }
    }

    private static void check(ArrayList<Integer> tmpArr) {
        int tmp = 0;
        for (int i = 0; i < tmpArr.size(); i++) {
            if (tmpArr.get(i) == 0) {
               if (wom[i] == 2) {
                   tmp++;
               }
            } else if (tmpArr.get(i) == 1) {
                if (wom[i] == 0) {
                    tmp++;
                }
            } else if (tmpArr.get(i) == 2) {
                if (wom[i] == 1) {
                    tmp++;
                }
            }
        }
        if (tmp == s) {
            System.out.println(tmpArr.toString());
            ans++;
        }
    }


}
