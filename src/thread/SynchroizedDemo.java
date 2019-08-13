package thread;

/**
 * @author xuzhangwang
 */
public class SynchroizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized：代码块");
        }
    }
}
