package yearof2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 贝壳找房_最少按键次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        // 开始控大写关闭
        boolean flag = false;
        int sum = 0;

        List<String> list = new ArrayList<>();
        for (char ch : c) {
            // 当前大写模式
            if (flag) {
                if (Character.isLowerCase(ch)) {
                    list.add("Caps Lock");
                    list.add(String.valueOf(ch));
                    sum = sum + 2;
                    flag = !flag;
                    continue;
                } else {
                    list.add(String.valueOf(ch));
                    sum++;
                    continue;
                }
            }

            // 当前为小写锁定
            if (!flag) {
                if (Character.isUpperCase(ch)) {
                    list.add("Caps Lock");
                    list.add(String.valueOf(ch));
                    sum = sum + 2;
                    flag = !flag;
                    continue;
                } else {
                    list.add(String.valueOf(ch));
                    sum++;
                    continue;
                }
            }
        }

        System.out.println(sum);
        System.out.println(list.toString());
    }
}
