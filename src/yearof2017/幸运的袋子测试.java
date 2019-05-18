package yearof2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 幸运的袋子测试 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int i = 0;i < n;i++){
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);                  //a升序排列
            System.out.println(find(a, 0, 0, 1));
        }
    }

    private static int find(int[] a,int index,long sum,long multi){
        int count = 0;
        for(int i = index;i < a.length;i++){
            sum += a[i];
            multi *= a[i];

            if(sum > multi){
                count = count + 1 + find(a, i+1, sum, multi);
            }
            else if (a[i] == 1) {
                //处理待判断的序列第一个数为1的时候，
                //那个1虽然不满足和大于积，但是要保留，继续往下考虑
                count = count + find(a, i+1, sum, multi);
            }
            else {
                break;
            }
            sum -= a[i];        //sum和multi在下一循环中还会用到
            multi /= a[i];
            for(;i < a.length-1 && a[i] == a[i+1];i++){
                //    i++;            //拥有相同号码的球是无区别的，因此跳过
            }
        }
        return count;
    }
}
