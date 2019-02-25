package chapter05;

/**
 * @Auther: xuzhangwang
 * @Tttle: 翻转字符串
 * @Description: 给定一个字符类型的数组chas，请在单词间左逆序调整。只要做到单词顺序逆序既可。对空哥哥的位置没有特别的要求。
 */
public class Chapter05_rorateWord {
    public static void main(String[] args) {
        String str = "ABCDE";
        int size = 3;
        char[] chas = str.toCharArray();
//        rotateWord(chas);
//        System.out.println(String.valueOf(chas));
        rotate(chas, size);
        System.out.println(String.valueOf(chas));
    }
    private static void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        reverse(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        // 接下来是将单词进行倒转
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ' ') {
                // 确定左边界
                l = i == 0 || chas[i - 1] == ' ' ? i : l;
                // 确定右边界
                r = i == chas.length - 1 || chas[i + 1] == ' ' ?  i : r;
            }
            // 如果变量r和l同时不等于-1的话就代表当前的l和r已经发生过改变，并且要进行字符串的翻转
            if (l != -1 && r != -1) {
                reverse(chas, l , r);
                l = -1;
                r = -1;
            }
        }
    }

    private static void reverse(char[] chas, int l, int r) {
        char tmp = 0;
        while(l < r) {
            tmp = chas[l];
            chas[l] = chas[r];
            chas[r] = tmp;
            l++;
            r--;
        }
    }

    /*
        补充题目:给定一个字符类型数组chas和一个整数size，请把size的左边半区整体移动到右边半区，右边半区的整体的移动到左边半区
        解决方法是: 先把两部分的进行翻转，在将其他部分及进行翻转。
    */
    public static void rotate(char[] chas, int size) {
        if (chas == null || chas.length == 0) {
            return;
        }
        reverse(chas, 0, size - 1);
        reverse(chas, size, chas.length - 1);
        reverse(chas, 0, chas.length - 1);
    }
}
