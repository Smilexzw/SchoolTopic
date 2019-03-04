package yearof2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
 * 输入描述:
 * 输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 50000。
 * 第二行是希望去掉的数字数量cnt 1 ≤ cnt < length(number)。
 * 输出描述:
 * 输出保留下来的结果。
 * 
 * 示例1
 * 输入
 * 复制
 * 325 1
 * 输出
 * 复制
 * 35
 */
public class 搜狐_保留最大的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number =sc.nextLine();
        int cnt = sc.nextInt();
        StringBuffer sb = new StringBuffer(number);
        for (int i = 0; i < cnt; i++) {
            int j = 0;
            while (j + 1 < sb.length() && sb.charAt(j) >= sb.charAt(j + 1)) {
                j++;
            }
            sb.deleteCharAt(j);
        }
        System.out.println(sb.toString());
    }
}
