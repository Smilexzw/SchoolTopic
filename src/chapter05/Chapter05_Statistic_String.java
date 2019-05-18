package chapter05;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Chapter05_Statistic_String {
    public static void main(String[] args) {
        String str = "aaabbadddffcc";
        String result = getCountString(str);
        System.out.println(result);
    }
    public static String getCountString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != chs[i - 1]) {
                // 如果chs[i] != chs[i-1]则代表队的是连续截至
                // 不同的位置就会使用连接方法
                res = concat(res, String.valueOf(num), String.valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }
        //到了结尾的部分就要加上" ",来保证输出的字符是正确的, s3代表的是加上的当前的不同的字符
        return concat(res, String.valueOf(num), "");
    }

    // 连接a_3_b, 作为一个整体, 如果s3为"",就表示当前已经到达最后的位置
    // s1= a, s2= 3, s3=b res=a_3_b    最后的位置有 s1=a_3_b_2_a_1_d_3_f_2_c, s2=2, s3=""
    public static String concat(String s1 ,String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }
}

