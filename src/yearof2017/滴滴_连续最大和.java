package yearof2017;

import java.util.Scanner;

public class 滴滴_连续最大和 {
    /**
     *
     * @Title: getMax
     * @Description: 求一个数组的最大连续子序列的和
     * @param @param arr 输入进来的数组
     * @param @return max 得到最大的解
     * @return int    返回类型
     * @throws
     */
    public static int getMax(int[] arr) {
		/*
		 *  设置一个最大值max用来记录当前连续求到的最大子序列的值
		 *  设置一个值sum用来记录当前连续数组元素中能取到的最大值
		 *  当sum小于0的时候就将sum置于0, 因为一个数加上一个小于0的数, 这个数一定是小于本身的
		 */
        int max = arr[0], sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) sum = 0;
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(getMax(arr));
    }
}

