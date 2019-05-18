package year2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_奶牛编号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);

        long count = 1;
        // 可以先对x[i]按从小到大排好序，所以编号方法总数为x[0]*(x[1]-1)*(x[2]-2)*...*(x[n-1]-(n-1))。
        for (int i = 0; i < arr.length; i++) {
            count = ((arr[i] - i) * count) % 1000000007;
        }

        System.out.println(count);
    }

}
