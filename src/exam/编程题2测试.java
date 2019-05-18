package exam;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 编程题2测试 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] a = new int[n+1];
            in.nextLine();
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
            }
            a[n] = -1;                       //数组最后加上一个元素-1，使得栈中没出栈的元素全部出栈
            int max = 0;
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<=n;i++){
                while(!stack.isEmpty() && a[i]<=a[stack.peek()]){
                    int temp = a[stack.pop()];                  //出栈元素作为扩张区间的最小值
                    int start = stack.isEmpty() ? -1 : stack.peek();
                    int sum = 0;
                    for(int j=start+1;j<i;j++){          //计算扩张区间所有元素的和
                        sum += a[j];
                    }
                    max = Math.max(max, temp*sum);
                }
                stack.push(i);
            }
            System.out.println(max);
        }
    }

}

