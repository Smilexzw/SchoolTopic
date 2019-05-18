package offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author: xuzhangwang
 */
public class 和为S的连续正数序列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(sum);
        for (ArrayList<Integer> list : res) {
            System.out.println(list.toString());
        }
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 2) return res;
        // 使用两个快慢指针，来移动记录两个指针之间的和
        int start = 1;
        int end = 2;
        int curSum = 3;

        while (start < end) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                // 如果相等就的有以下开始统计
                ArrayList<Integer> list = new ArrayList();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                res.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return res;
    }

}
