package year2018;

import java.util.Scanner;

/**
 * 题目描述
 * 数据分页,对于指定的页数和每页的元素个数，返回该页应该显示的数据。
 * 输入描述:
 * 第一行输入数据个数，第二行全部数据，第三行输入页数，第四行输入每页最大数据个数
 * 输出描述:
 * 输出该页应该显示的数据，超出范围请输出'超过分页范围'
 * 示例1
 * 输入
 * 复制
 * 6
 * 1 2 3 4 5 6
 * 1
 * 2
 * 输出
 * 复制
 * 3
 * 4
 *
 * @author: xuzhangwang
 */
public class 搜狐畅游_数据分页说明 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int page = sc.nextInt();
        int max = sc.nextInt();
        sc.close();

        int p = 0;
        if (n % max == 0) {
            p = n / max;
        } else {
            p = n / max + 1;
        }


        if (page > p) {
            System.out.println("超出分页范围");
        } else {
            int start = page * max;
            for (int i = start; i < ((start + max) > n ? n : (start + max)); i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
