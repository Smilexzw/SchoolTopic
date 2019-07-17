package offer;

import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 整数中出现1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long start = System.currentTimeMillis();
        int res = NumberOf1Between1AndN_Solution(n);
        System.out.println(res);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 1; i <= n; i++) {
//            sb.append(i);
//        }
//
//        int count = 0;
//        for (int i = 0; i < sb.length(); i++) {
//            if (sb.charAt(i) == '1') {
//                count++;
//            }
//        }
//        return count;

       /* 数学之美公式,对于上面产生的三种分析用一个公式概括
          case0: n=3141092 a=31410 b = 92 计算百位上1的次数为3141 * 100次数
          case1: n=3141092 a=31410 b = 92 计算百位上1的次数为3141 * 100 + (92 + 1)次数
          case>=2: n=3141092 a=31410 b = 92 计算百位上1的次数为(3141 + 10) * 100次数
        * （a + 8）/ 10 * m + (a % 10 == 1 ? (b + 1) : 0)
         * */
        int cnt = 0;
        for (int i = 1; i <= n; i*=10) {
            int a = n / i;
            int b = n % i;
            cnt += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
            if (i > 100000000) break; // 防止数据的溢出
        }
        return cnt;
    }
}
