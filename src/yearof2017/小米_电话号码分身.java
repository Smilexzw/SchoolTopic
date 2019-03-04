package yearof2017;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 小米_电话号码分身 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            valid(sc.nextLine());
        }
    }

    public static void valid(String str) {
        str = str.toLowerCase();
        int[] nums = new int[10];
        StringBuffer sb = new StringBuffer(str);
        // 删除0
        while (sb.toString().contains("z")) {
            nums[2]++;
            sb.deleteCharAt(sb.indexOf("z"));
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("r"));
            sb.deleteCharAt(sb.indexOf("o"));
        }
        // 删除2
        while (sb.toString().contains("w")) {
            nums[4]++;
            sb.deleteCharAt(sb.indexOf("t"));
            sb.deleteCharAt(sb.indexOf("w"));
            sb.deleteCharAt(sb.indexOf("o"));
        }
        // 删除4
        while (sb.toString().contains("u")) {
            nums[6]++;
            sb.deleteCharAt(sb.indexOf("f"));
            sb.deleteCharAt(sb.indexOf("o"));
            sb.deleteCharAt(sb.indexOf("u"));
            sb.deleteCharAt(sb.indexOf("r"));
        }
        // 删除6
        while (sb.toString().contains("x")) {
            nums[8]++;
            sb.deleteCharAt(sb.indexOf("s"));
            sb.deleteCharAt(sb.indexOf("i"));
            sb.deleteCharAt(sb.indexOf("x"));
        }
        // 删除8
        while (sb.toString().contains("g")) {
            nums[0]++;
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("i"));
            sb.deleteCharAt(sb.indexOf("g"));
            sb.deleteCharAt(sb.indexOf("h"));
            sb.deleteCharAt(sb.indexOf("t"));
        }
        // 删除5 就是第二个five
        while (sb.toString().contains("f")) {
            nums[7]++;
            sb.deleteCharAt(sb.indexOf("f"));
            sb.deleteCharAt(sb.indexOf("i"));
            sb.deleteCharAt(sb.indexOf("v"));
            sb.deleteCharAt(sb.indexOf("e"));
        }
        // 删除 7 seven
        while (sb.toString().contains("s")) {
            nums[9]++;
            sb.deleteCharAt(sb.indexOf("s"));
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("v"));
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("n"));
        }
        // 删除3 t three
        while (sb.toString().contains("t")) {
            nums[5]++;
            sb.deleteCharAt(sb.indexOf("t"));
            sb.deleteCharAt(sb.indexOf("h"));
            sb.deleteCharAt(sb.indexOf("r"));
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("e"));
        }
        // 删除1 o one
        while (sb.toString().contains("o")) {
            nums[3]++;
            sb.deleteCharAt(sb.indexOf("o"));
            sb.deleteCharAt(sb.indexOf("n"));
            sb.deleteCharAt(sb.indexOf("e"));
        }
        // 删除9
        while (sb.toString().contains("n")) {
            nums[1]++;
            sb.deleteCharAt(sb.indexOf("n"));
            sb.deleteCharAt(sb.indexOf("i"));
            sb.deleteCharAt(sb.indexOf("n"));
            sb.deleteCharAt(sb.indexOf("e"));
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                System.out.print(i);
            }
        }
        System.out.println();
    }

}
