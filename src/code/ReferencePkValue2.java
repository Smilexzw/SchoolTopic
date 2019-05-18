package code;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class ReferencePkValue2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        test(a, b);
        System.out.println(a +"," + b);
        Integer a1 = 1;
        Integer b1 = 2;
        test1(a1, b1);
        System.out.println(a1+"," + b1);
    }

    private static void test1(Integer a1, Integer b1) {
        Integer t = a1;
        a1 = b1;
        b1 = t;
    }

    private static void test(int a, int b) {
        int  t= a;
        a = b ;
        b = t;
    }
}