package chapter05;

/**
 * @Auther: xuzhangwang
 * @Title: 字符串的调整和替换
 * @Description: 给定一个字符串的的数组chas[]，chas的右边全是空的字符，左半区是不含有空的字符。
 * 现在想要将作伴去所有的空格字符替换成为‘%20’，假设chas的右边半区足够的大，替换后，可以满足替换所需要的空间
 *
 */
public class Chapter05_StringReplace {
    public static void main(String[] args) {
        char[] chas = new char[100];
        chas[0] = 'a';
        chas[1] = '\0';
        chas[2] = 'b';
        chas[3] = '\0';
        chas[4] = '\0';
        chas[5] = 'c';
        replcae(chas);
        String str = String.valueOf(chas);
//        for (int i = 0; i < 20; i++) {
//            System.out.print(chas[i]);
//        }
        System.out.println(str);
    }

    // 只需要算出数组的长度和数组中空格的数量既可以得出所想要的结果
    public static void replcae(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int num = 0;
        int len = 0;
        for (len = 0; len < 5; len++) {
            if (chas[len] == '\0') {
                num++;
            }
        }
        // 扩展之后的数组的长度是length = len + num * 2;
        int j = len + num * 2;
        // 从字符数组的后面开始替换
        for (int i = len; i > 0 ; i--) {
            if (chas[i] != '\0') {
                chas[j--] = chas[i];
            } else {
                chas[j--] = '0';
                chas[j--] = '2';
                chas[j--] = '%';
            }
        }
    }
}
