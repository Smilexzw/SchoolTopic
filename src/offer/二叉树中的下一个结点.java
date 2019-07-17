package offer;

import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 二叉树中的下一个结点 {
    static String s = "";
    static char[] hash = new char[256];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        for (char c : str.toCharArray()) {
            Insert(c);
        }
        char res = FirstAppearingOnce();
        System.out.println(res);
        System.out.println(s);
    }

    public static void Insert(char ch)
    {
        s+=ch;
        // 计算每个位置是否会出现两次
        hash[ch]++;

    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        for(int i = 0; i < s.length(); i++) {
            if(hash[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return '#';
    }
}
