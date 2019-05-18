package exam;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 字符串S由小写字母构成，长度为n。
 * 定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。
 * 询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 */
public class 字节跳动笔试 {
    public static int dp(int i,int j,int[] location){
        if(i==j){
            return 0;
        }
        else if(i+1==j){
            return location[j]-location[i]-1;
        }
        else {
            //（j-i-1）表示中间还有相同字母个数（相当于i+1=j时中间相同字母个数为0）
            return dp(i+1,j-1,location)+location[j]-location[i]-(j-i-1)-1;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        char[] arrStr = str.toCharArray();
        int m = sc.nextInt();
        int[][] binStr= new int[arrStr.length][26];
        for(int i = 0;i <arrStr.length;i++){
            binStr[i][arrStr[i]-'a'] =1;
        }
//        for(int i = 0;i <binStr.length;i++ ){
//            for(int j = 0;j < 26 ;j++){
//                System.out.print(binStr[i][j]);
//            }
//            System.out.println();
//        }
        int[] num = new int[26];//记录每个字母最长数量(规定移动次数范围内)
        for(int j = 0;j < 26 ;j++){//第i个字母
            int[] location = new int[len];
            int k = 0;
            for(int i =0 ;i<len;i++){
                if(binStr[i][j]==1)
                    location[k++] = i;
            }
            if(k == 1){//字符串中只有一个字母
                num[j] = 1;
            }
            else{
                int temp = -1;
                for(int i = 0;i < k;i++){
                    for(int ii = i+1;ii<k;ii++){
                        int re = dp(i,ii,location);
                        if(re<=m){
                            if(ii-i+1>temp){
                                temp = ii-i+1;
                            }
                        }
                    }
                }
                num[j] = temp;
            }
        }
        int sum = num[0];
        for(int i = 1;i<26;i++){
            if(num[i]>sum){
                sum = num[i];
            }
        }
        System.out.println(sum);
    }

}
