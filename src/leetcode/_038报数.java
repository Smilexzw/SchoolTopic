package leetcode;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class _038报数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String res = countAndSay(n);
        System.out.println(res);
    }

    public static String countAndSay(int n) {
        int i = 1;
        String res = "1";
        while (i < n) {
            int count = 0;
            StringBuffer sb = new StringBuffer();
            char c = res.charAt(0);
            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && res.charAt(j) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    if (j != res.length()) {
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            res = sb.toString();
            i++;
        }
        return res;
    }


    public static String countAndSay1(int n) {
        if(n == 1){
            return "1";
        }
        //递归调用，然后对字符串处理
        String str = countAndSay1(n-1) + "*";//为了str末尾的标记，方便循环读数
        char[] c = str.toCharArray();
        int count = 1;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < c.length - 1;i++){
            if(c[i] == c[i+1]){
                count++;//计数增加
            }else{
                //s.append(s);
                s.append("" + count + c[i]);//上面的*标记这里方便统一处理
                count = 1;//初始化
            }
        }
        return s.toString();
    }
}
