package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description: 67. 二进制求和
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (266)
 * 题解
 * 提交记录
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class _067二进制求和 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String res = addBinary(a, b);
        System.out.println(res);
    }

    public static String addBinary(String a, String b) {
        if (a == "") return b;
        if (b == "") return a;
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;
        while (i >= 0 || j >= 0) {
            int sum = remainder;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder != 0) {
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
}
