package offer;


/**
 * @author: xuzhangwang
 */
public class 不用加减乘除做加法 {
    public static void main(String[] args) {
        int res = Add(5, 7);
        System.out.println(res);
    }

    /**
     *  在十进制中模拟5+7
     *  第一部分 不算进位 2
     *  第二部分 计算进位值 10， 如果这一步的进位值为0，那么这一步得到的值就是最终答案
     *  第三部分 重复上述两部2 + 10
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1,int num2) {

        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
