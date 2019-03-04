package yearof2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，
 * 但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
    输入描述:
       每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），
        接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
    输出描述:
    输出一行表示合法的排列数目。
 */
public class 网易_数列还原 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n];
        int zero = 0;
        boolean[] isZero = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            if (A[i] == 0) {
                zero++;
            } else {
                isZero[A[i]] = true;
            }

        }
        sc.close();
        int[] arr = new int[zero];
        int index = 0;
        for (int i = 1; i < isZero.length; i++) {
            if (isZero[i] == false) {
                arr[index++] = i;
            }
        }

        // ================================ 我是分界线 ，上面算出 缺少的数字哪一些，
        // 顺序对是指满足 i < j 且 A[i] < A[j]
        // 所以先算出当前位置


        // k == 最开始的顺序对 + 没有填进去的顺序对 + 填进去的顺序对
        dfs(0, arr, A, k);
        System.out.println("结果=" + ans);


    }

    private static void dfs(int i, int[] arr, int[] A, int k) {
        if (i == arr.length - 1) {
            int[] ints = Arrays.copyOf(A, A.length);
            ckeck(arr, ints, k);
        }
        for (int j = i; j < arr.length; j++) {
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;

            dfs(i + 1, arr, A, k);

            // 回溯
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;

        }
    }

    private static void ckeck(int[] arr, int[] ints, int k) {
        // 检查顺序对
        int tmpk = 0;
        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                ints[i] = arr[index++];
            }
        }
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                if (i < j && ints[i] < ints[j] ) {
                    tmpk++;
                }
            }
        }
        if (tmpk == k) {
            ans++;
        }
    }

}
