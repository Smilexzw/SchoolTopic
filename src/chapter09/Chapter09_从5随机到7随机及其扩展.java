package chapter09;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Chapter09_从5随机到7随机及其扩展 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(rand1To5());
        }
    }

    public static int rand1To5() {
        return (int) ((Math.random() * 5) + 1);
    }


}
