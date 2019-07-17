package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class _118杨辉三角 {


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 0) return res;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }

        for (List<Integer> a : res) {
            System.out.println(a.toString());
        }
        return res;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    m[i][j] = 1;
                } else {
                    m[i][j] = m[i - 1][j - 1] + m[i - 1][j];
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        generate(n);
    }


}
