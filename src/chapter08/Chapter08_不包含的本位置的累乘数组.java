package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 不包含本位置的累乘数组
 * 给定一个整形数组arr， 返回不包含本位置的累乘数组
 */
public class Chapter08_不包含的本位置的累乘数组 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4};
        int[] product = product2(arr);
        for (int i = 0; i < product.length; i++) {
            System.out.println(product[i]);
        }
    }

    /**
     * 使用最常规的方法进行计算
     * @param arr
     * @return
     */
    public static int[] product(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int cur = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    cur *= arr[j];
                }
                res[i] = cur;
            }
        }
        return res;
    }

    /**
     * 使用除法进行计算，如果除法，结果数组即为res， 所有数的乘积为all。如果数组中不含的有0， 设置res[i] = all / arr[i]
     * 如果含有1个0， 对唯一的arr【i】 == 0的位置令res【i】= all, 其他位置都是的0
     * 对于超过1个0， res中的数值全部都是0
     * @param arr
     * @return
     */
    public static int[] product1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        int count = 0;
        int all = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                all *= arr[i];
            } else {
                count++;
            }
        }
        // 对于以上三种情况进行分析
        int[] res = new int[arr.length];
        if (count == 0) {
            for (int i = 0; i < arr.length; i++) {
                res[i] = all / arr[i];
            }
        }

        // 只有一个0 的情况就直接返回， 对于唯一一个0的位置就返回all， 其他的位置返回0
        if (count == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    res[i] = all;
                }
            }
        }
        return res;
    }


    /**
     * 不能使用除法的情况下， 可以用下方法实现进阶问题
     * 1、生成两个长度和arr一样的新数组lr【】 和 rl【】 lr表示从左到右的累乘
     * rl表示从从右到左的累乘
     * 2、一个位置除去自己值的累乘，就是自己左边的累成在乘以自己右边的累乘， 就是res[i] = lr[i - 1] * rl[i + 1].
     * 3、最左的位置和最右的位置比较特殊，res【0】 = rl[1] res[N - 1] = lr[N - 2]
     * @param arr
     * @return
     */
    public static int[] product2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i];
        }
        int tmp = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * tmp;
            tmp *= arr[i];
        }
        res[0] = tmp;
        return res;
    }
}
