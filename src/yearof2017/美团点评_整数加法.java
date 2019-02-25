package yearof2017;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 美团点评_整数加法 {
    static List<String> list = new ArrayList<String>();
    static List<String> result = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            list.add(str);
        }
        for (int i = 0; i < list.size(); i++) {
            String[] s = list.get(i).split(" ");
            if (isInteger(s[0]) && isInteger(s[1])) {
                // 使用大数据的类型开始的接受数据
                BigInteger bgA = new BigInteger(s[0]);
                BigInteger bgB = new BigInteger(s[1]);
                result.add(bgA.add(bgB).toString());
            } else {
                result.add("Error");
            }
        }

        // 输出结果
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }


    // 使用正则表达式来判断一个字符串是否为一个整数
    public static boolean isInteger(String str) {
        return str.matches("[0-9]+");
    }
}

