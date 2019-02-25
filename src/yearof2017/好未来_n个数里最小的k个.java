package yearof2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 好未来_n个数里最小的k个 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 用string 数组来存放数据
        String[] str = sc.nextLine().split(" ");
        // 创建一个int数组来存放数据
        // 最后一个数据为k值
        int[] arr = new int[str.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < Integer.parseInt(str[str.length - 1]); i++) {
            System.out.print(arr[i]);
            if(i!=Integer.parseInt(str[str.length-1])-1){
                System.out.print(" ");
            }
        }
        // 最后一个位置也要空格

    }
}
