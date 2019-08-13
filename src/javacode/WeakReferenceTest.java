package javacode;

import _316.Test;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 软引用
 * @author xuzhangwang
 * @date 2019/8/2
 */
public class WeakReferenceTest {
    static class TestObject { }

    public static void main(String[] args) throws InterruptedException {
        WeakReference<TestObject> weakReference = new WeakReference<TestObject>(new TestObject());
        // 判断当前对象是否死亡
        System.out.println(weakReference.get() == null);
        // 开启垃圾回收
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(weakReference.get() == null);
    }
}
