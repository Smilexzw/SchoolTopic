package chapter05;

/**
 * @Auther: xuzhangwang
 * @Title: 字符串中数字字串的求和
 * @Description: 给定一个字符串str，求其全部数字字串所代表的数字之和
 * 要求： 1、忽略小数点的字符
 *       2、如果紧贴数字字串左侧出现的字符‘-’，但连续出现的数量为奇数的时候，则数字则视为负数
 *       但连续出现的数量为偶数的时候就视为正数
 */
public class Chapter05_numSum {
    public static void main(String[] args) {
        String str = "A-1B--2C--D6E";
        int result = numSum(str);
        System.out.println(result);
    }

    public static int numSum(String str) {
        if (str == null) return 0;
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (charArr[i] == '-') {
                    // 如果当前一个位置不小于0且字符也是'-'就将符号至于相反
                    if (i - 1 > -1 && charArr[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }
}
