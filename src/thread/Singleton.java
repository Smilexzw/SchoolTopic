package thread;

/**
 * 双重校验实现对象单例（线程安全）
 * @author xuzhangwang
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {}


    public static Singleton getUniqueInstance() {
        // 先判断对象是否已经实例化过了，没有实例化才进入加锁代码
        if (uniqueInstance == null) {
            // 类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getUniqueInstance();
        Singleton s2 = Singleton.getUniqueInstance();
        System.out.println(s1);
        System.out.println(s2);
    }
}
