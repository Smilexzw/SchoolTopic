package yearof2017;

import java.util.Scanner;

public class 网易_优雅的点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long startTime = System.currentTimeMillis();//获取当前时间
        System.out.println(getPoint(n));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");
    }

    public static int getPoint(int n) {
        int count = 0;
        // 定义一个不是i和j相等的数
        double tmp = Math.sqrt(n);
//		if (n % tmp != 0) {
//			return 0;
//		}
        // 如果tmp是整数的话直接加上在x轴和y轴上的四个点就行, 除了零点
        for (int i = new Double(tmp).intValue(); i > 0 ; i--) {
//			for (int j = 0; j <= tmp; j++) {
//				if ( i + j > tmp && (i * i + j * j == n)) {
//					System.out.println("i = " + i + ",j = " + j);
//					count++;
//				}
//			}
//          使用这个方法会导致超时
            double j = Math.sqrt(n - i * i);
            // 只要判断j 是否为整数
            if (j == new Double(j).intValue()) {
                System.out.println("i = " + i + ",j = " + j);
                count++;
            }
        }
        return count * 4;
    }
}

