package javacode;

import java.util.concurrent.TimeUnit;

/**
 * 强引用的无法的被垃圾回收器回收的
 * @author xuzhangwang
 * @date 2019/8/2
 */
public class StrongReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        StrongReferenceTest object = new StrongReferenceTest();
        System.gc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(object == null);
    }
}
