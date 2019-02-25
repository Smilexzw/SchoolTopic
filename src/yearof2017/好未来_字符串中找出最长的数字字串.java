package yearof2017;

import java.util.Scanner;

public class 好未来_字符串中找出最长的数字字串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = 0;
        int count = 0;
        int end = 0;
        // 定义最大的值为0,设置一个计数器，将计数器count, 用计数器来记录计数器的使用
        // 如果当前位置的数据是不符合0-9的数据则表示当前的数据是无效的
        // 设置一个end结束的变量，将用于记录结束的位置
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count++;
                if (max < count) {
                    max = count;
                    end = i;
                }
            } else {
                // 如果当前的数据是无效的就将count设置为0
                count = 0;
            }
        }
        // 使用正则表达式进行判断，匹配, \D表示的为非数字字符，使用非数字字符进行切分.
//		String[] s = str.split("[\\D]+");
//		String result = "";
//		for (int i = 0; i < s.length; i++) {
//			if (max < s[i].length()) {
//				result = s[i];
//				max = s[i].length();
//			}
//		}
        System.out.println(str.substring(end - max + 1, end + 1));
    }
}
