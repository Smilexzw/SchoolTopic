package chapter04;

/**
 * @Auther: xuzhangwang
 * @Title: 跳跃游戏
 * @Description: 给定数组arr, arr[i] == k代表可以从位置i向跳1~k的距离。最后到达最后一个位置的距离
 */
public class Chapter04_JumpGame {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        int jump = jump(arr);
        System.out.println(jump);
    }
    
    public static int jump(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }
}
