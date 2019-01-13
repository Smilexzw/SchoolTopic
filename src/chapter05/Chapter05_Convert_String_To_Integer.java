package chapter05;

/**
 * @Auther: xuzhangwang
 * @Title: 将整数字符串转成整数值
 * @Description: 给定一个字符串str，如果str符合日常书写的整数形式，且在32位整数的范围内，就返回str所代表的整数值
 * Str = "123" 返回123
 * Str = "023" 不符合日常的书写习惯，所以返回0
 * Str = "A12" 返回0
 * Str = "2147483647" 返回2147483647
 * Str = "2147483648" 返回0,溢出
 */
public class Chapter05_Convert_String_To_Integer {
    public static void main(String[] args) {
        String str = "-2147483641";
        int result = convert1(str);
        System.out.println(result);
        System.out.println(Integer.MIN_VALUE);
    }

    // 验证数字是否是合法
    public static boolean isValid(char[] chas) {
        // A12的这种情况
        if (chas[0] != '-' && (chas[0] < '0' || chas[0] > '9')) return false;
        // 0和-023的这种情况
        if (chas[0] == '-' && (chas.length == 1 || chas[1] == '0')) return false;
        // 023的这种情况
        if (chas[0] == '0' && chas.length > 1) return false;
        // 判断溢出不在此处
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] < '0' || chas[i] > '9')
                return false;
        }
        return true;
    }

    // 字符串进行转
    public static int convert(String str) {
        if (str == null || str.equals("")) return 0;
        char[] chas = str.toCharArray();
        if (!isValid(chas)) {
            // 不能转
            return 0;
        }
        // 判断是否溢出，不能直接使用Integer.valueOf(),使用的话得catch异常
        try {
            Integer.valueOf(str);
        } catch (Exception e) {
            System.out.println("捕获到异常");
            return 0;
        }
        return Integer.valueOf(str);
    }

    // 字符串进行转,不使用Java的catch的异常，去除语法的特性
    public static int convert1(String str) {
        if (str == null || str.equals("")) return 0;
        char[] chas = str.toCharArray();
        if (!isValid(chas)) {
            // 不能转
            return 0;
        }
        // 现在只需要判断当前的数字是正数还是负数, 如果为负数就为false，正数就是true
        boolean posi = chas[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;     // 设置的最小值
        int minr = Integer.MIN_VALUE % 10;     // 加上当前的值，判断是否会溢出
        int res = 0;
        int cur = 0;
        // 负数的话从i=1的位置开始，正数的话从开始, 统一变成负数
        for (int i = posi ? 0 : 1; i < chas.length; i++) {
             cur = '0' - chas[i];
             if (res < minq || (res == minq && cur < minr)) {
                 return 0;
             }
             res = res * 10 + cur;
         }
         // 整数的范围是-2147483648~2147483648
         // 这里统一设置成负数，所以要转变
         return posi ? -res : res;
    }
}
