package yearof2017;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 网易_不要二 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // 初始数组为1
        int[][] arr = new int[x][y];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 1;
            }
        }
        // 不能放棋子的位置置为0
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0 && (i + 2) < arr.length) {
                    arr[i + 2][j] = 0;
                }
                if (arr[i][j] != 0 && (j + 2) < arr[0].length) {
                    arr[i][j + 2] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) count++;
            }
        }
        System.out.println(count);
    }
}
