package offer;
/**
 * @author xuzhangwang
 */
public class 数组中出现超过一般的数目 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,4,4,5,4,4};
        int res = MoreThanHalfNum_Solution(arr);
        System.out.println(res);
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        int count = 1;
        int k = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    k = array[i];
                    count = 1;
                }
            }
        }

        // 在验证一遍
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        if (count * 2 > array.length) return k;
        return 0;
    }
}
