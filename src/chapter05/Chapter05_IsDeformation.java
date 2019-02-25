package chapter05;

/**
 * @Auther: xuzhangwang
 * @Description: 给定两个字符串Str1和Str2, 如果两个字符串出现的字符种类和次数相等就是互为变形词
 */
public class Chapter05_IsDeformation {
    public static void main(String[] args) {
        String str1 = "abcda";
        String str2 = "abbda";
        boolean result = isDeformation(str1, str2);
        System.out.println(result);
    }

    // 这里演示的是出现字符为0~255的字符, 所以申请255的空间
    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[255];
        for (int i = 0; i < chas1.length; i++) {
            map[chas1[i]]++;
        }
        for (int i = 0; i < chas2.length; i++) {
            // 判断当前位置的值是否是小于0的，如果小于就是false
//            if (map[chas2[i]]-- == 0) {
//                return false;
//            }
            map[chas2[i]]--;
            if (map[chas2[i]] < 0) return false;
        }
        return true;
    }

}
