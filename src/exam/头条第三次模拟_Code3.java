package exam;


import java.util.Scanner;


// 通过了80%的输出测试用例

public class 头条第三次模拟_Code3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        boolean end = true;
        int ans = 0;
        int last = x;
        int index = x;
        while (end) {
            if (index == 1) {
                int tmp = arr[index] - 1;
                if (tmp < 0) {
                    last = index;
                    break;
                } else {
                    arr[index]--;
                    ans++;
                    index = n;
                }
            } else {
                int tmp = arr[index] - 1;
                if (tmp < 0) {
                    last = index;
                    break;
                } else {
                    arr[index]--;
                    ans++;
                    index--;
                }
            }
        }
        arr[last] = ans;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
