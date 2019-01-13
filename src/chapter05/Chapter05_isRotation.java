package chapter05;

/**
 * @Auther: xuzhangwang
 * @Title: 判断两个字符串是否为旋转词
 * @Description: 如果一个字符串str， 把字符串得str前面的任意的部分挪到后面形成的字符串叫做str的旋转词
 */
public class Chapter05_isRotation {
    public static void main(String[] args) {
        String a = "cdab";
        String b = "abcd";
        System.out.println(isRotation(a, b));
        String a1 = "1ab2";
        String b1 = "ab12";
        System.out.println(isRotation(a1, b1));
        String a2 = "2ab1";
        String b2 = "ab12";
        System.out.println(isRotation(a2, b2));
    }

    // 如果两个字符串的长度不相等，就不可能为旋转词
    // 如果a和b的长度一样长，先生成大字符串的 bb=b+b, 如果bb包含的字符串a，则就是旋转词语
    // 直接使用的Java的indedxOf()的方法，如果字符串包含了的目标字符串，则会返回到第一次的出现的位置，没有的话就返回-1
    public static boolean isRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        String bb = b + b;
        return bb.indexOf(a) == -1 ? false : true;
    }
}
