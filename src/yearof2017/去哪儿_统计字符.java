package yearof2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 去哪儿_统计字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 使用正则表达式进行数据的更换， 以后遇到字符串的问题首先要考虑到正则表达式子
        char[] chars = sc.nextLine().replaceAll("[^a-zA-Z]", "").toCharArray();
        sc.close();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.containsKey(chars[i]) ? map.get(chars[i]) + 1 : 1);
            if (map.get(chars[i]) == 3) {
                System.out.println(chars[i]);
                break;
            }
        }

    }
}
