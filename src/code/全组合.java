package code;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 全组合 {
    public static void main(String[] args) {
        String[] str = {"1", "1", "2", "3"};
        int n = str.length;
        int nbit = 1 << n;
        for (int i = 0; i < nbit; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j;
                if ((tmp & i) != 0) {
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}
