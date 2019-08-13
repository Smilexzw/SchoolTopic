package thread;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 使用ThreadLocal
 * 简单的例子， 比如两个人去房子中的收集宝物，这两个宝物的公用一个袋子的话肯定会出现的争执，但是给他们每个人分配一个袋子的话就不会出现这样的问题，如果把这两个人的比作线程的话，那么ThreadLocal就是避免这两个线程竞争的。
 * @author xuzhangwang
 */
public class ThreadLocalExaple implements Runnable{

    // SimpleDateFormat是线程不安全的，所以每个线程都要有自己的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHdd"));


    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExaple obj = new ThreadLocalExaple();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name=" + Thread.currentThread().getName() + "default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name=" + Thread.currentThread().getName() + "formatter = " + formatter.get().toPattern());
    }
}
