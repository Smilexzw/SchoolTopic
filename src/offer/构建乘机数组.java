package offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 思路：一个位置的乘机是不包含自己的乘机，所以只要一个位置的乘机分为左边的乘机 X 右边的乘机
 * @author xuzhangwang
 */
public class 构建乘机数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        multiply(A);
    }


    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        int len = A.length;
        int[] left = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * A[i - 1];
        }

        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i + 1];
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = left[i] * right[i];
        }
        return A;
    }

}
