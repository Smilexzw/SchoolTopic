package year2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 工厂生产的产品包装在相同高度h，尺寸为1 * 1,2 * 2，3 * 3，4 * 4，5 * 5，6 * 6的方形包装中。
 * 这些产品始终以与产品高度相同的尺寸为6 * 6的包裹交付给客户。因为邮费很贵，所以工厂要想方设法的减小每个订单运送时的包裹数量。
 * 他们很需要有一个好的程序帮他们解决这个问题从而节省费用。现在这个程序由你来设计。
 * <p>
 * 输入描述:
 * 输入文件包括几行，每一行代表一个订单。每个订单里的一行包括六个整数，
 * 中间用空格隔开，分别为 1*1 至 6*6 这六种产品的数量。输入文件将以 6 个 0 组成的一行结尾。
 * 输出描述:
 * 除了输入的最后一行 6 个 0 以外，输入文件里每一行对应着输出文件的一行，每一行输出一个整数代表对应的订单所需的最小包裹数。
 * 示例1
 * 输入
 * 复制
 * 0 0 4 0 0 1
 * 7 5 1 0 0 0
 * 0 0 0 0 0 0
 * 输出
 * 复制
 * 2
 * 1
 *
 * @author: xuzhangwang
 */
public class 搜狐_包裹运输 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            boolean isEnd = true;
            int[] arr = new int[7];
            for (int i = 1; i < 7; i++) {
                int t = sc.nextInt();
                if (t != 0) {
                    isEnd = false;
                }
                arr[i] = t;
            }
            if (isEnd) {
                return;
            }
            int res = helper(arr);
            System.out.println(res);
        }


    }

    /*

    因为工厂审生产的箱子都是一样的高度
     一个六个的箱子全部装填，
     5，放入一个五之后，只能放1
     4放入之后，优先考虑2，在考虑1
      */

    private static int helper(int[] arr) {
        int count = 0;
        // 4 5 6每个必须占有一个箱子的
        for (int i = 4; i <= 6; i++) {
            count += arr[i];
        }
        // 3 * 3箱子
        count += (arr[3] + 3) / 4;

        // 计算剩下的箱子
        int emptyFor1 = 11 * arr[5];

        int emptyFor2 = 5 * arr[4];

        switch (arr[3] % 4) {
            case 1:
                emptyFor2 += 5;
                emptyFor1 += 7;
                break;
            case 2:
                emptyFor2 += 3;
                emptyFor1 += 6;
                break;
            case 3:
                emptyFor2 += 1;
                emptyFor1 += 5;
                break;
            default:
                break;
        }

        // 计算填充位置
        if (emptyFor2 > arr[2]) { // 2*2 填充不够
            emptyFor1 += (emptyFor2 - arr[2]) * 4;
        } else {  // 能够填满，剩余2*2数量，重新装在一个箱子
            int leaveFor2 = arr[2] - emptyFor2;
            count += (leaveFor2 + 8) / 9;
            // 剩下的空间
            emptyFor1 += (9 - leaveFor2 % 9) * 4;
        }

        if (emptyFor1 < arr[1]) { // 填充完还有剩余，重新装在一个箱子
            count += (arr[1] - emptyFor1 + 35) / 36;
        }
        return count;
    }
}
