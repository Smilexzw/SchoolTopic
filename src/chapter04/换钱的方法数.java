package chapter04;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class 换钱的方法数 {


    public static void main(String[] args) {
        int[] arr = {5,10,25,1};
        int aim = 15;
        int res = coins(arr, aim);
        System.out.println(res);
    }

    // 第一次使用递归
    public static int coins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return version1(arr, 0, aim);
    }

    private static int version1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            // 判断当前是否已经走到了最后的位置，在判断当前的钱是否用完
            res = aim == 0 ? 1 : 0;
        }   else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += version1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }
}
