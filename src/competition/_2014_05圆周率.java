package competition;

/**
 * @Auther: xuzhangwang
 * @Description: 数学发展历史上，圆周率的计算曾有许多有趣甚至是传奇的故事。其中许多方法都涉及无穷级数。
 * <p>
 * <p>
 *     图1.png中所示，就是一种用连分数的形式表示的圆周率求法。
 * <p>
 * <p>
 *     下面的程序实现了该求解方法。实际上数列的收敛对x的初始值 并不敏感。
 * <p>
 * <p>
 *     结果打印出圆周率近似值（保留小数点后4位，并不一定与圆周率真值吻合）。
 * <p>
 * <p>
 * double x = 111; 
 * for(int n = 10000; n>=0; n--){
 * int i = 2 * n + 1;
 * x = 2 + (i*i / x);
 * }
 * <p>
 * System.out.println(String.format("%.4f", ______________));
 */
public class _2014_05圆周率 {
    public static void main(String[] args) {

        double x = 111;
        for (int n = 10000; n >= 0; n--) {
            int i = 2 * n + 1;
            x = 2 + (i * i / x);
        }
        // 极限思维
        // n = 0 的时候 i = 0
        // x = 2 + 1 / x'
        // 但是最后的x比题目中的多了1 所以 x - 1
        // 4 / pi = x - 1           ==>  结果  4 / (x - 1)
        System.out.println(String.format("%.4f", 4 / (x - 1)));
    }
}
