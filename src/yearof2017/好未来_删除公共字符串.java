package yearof2017;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */


public class 好未来_删除公共字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String pattern = "[" + s2 + "]";
            String result = s1.replaceAll(pattern, "");
            System.out.println(result);
        }
    }
}
