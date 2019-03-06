package yearof2017;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: Please create a function to extract the filename extension from the given path,
 * return the extracted filename extension or null if none.
 */
public class 去哪儿_filename {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String res = "";
        boolean isFind = false;
        for (int i = str.length() - 1; i >=0; i--) {
            if (str.charAt(i) == '.') {
                isFind = true;
                break;
            } else {
                res += str.charAt(i);
            }
        }
        if (isFind == true) for (int i = res.length() - 1; i >= 0; i--) {
            System.out.print(res.charAt(i));
        } else {
            System.out.println("null");
        }
    }
}
