package code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xuzhangwang
 * @date 2019/8/2
 */
public class JDK动态代理案例 {
    public static void main(String[] args) {
        ClassLoader classLoader = JDK动态代理案例.class.getClassLoader();
        Class[] classes = { Waiter.class };
        Waiter waiter = new ManWaiter();
        InvocationHandler h = new WaiterInvocationhandler(waiter);
        Waiter waiterProxy = (Waiter) Proxy.newProxyInstance(classLoader, classes, h);

        waiterProxy.sever();
    }
}

interface Waiter {

    void sever();

}
class ManWaiter implements Waiter {

    @Override
    public void sever() {
        System.out.println("开始服务");
    }
}

class WaiterInvocationhandler implements InvocationHandler {

    private Waiter waiter;

    public WaiterInvocationhandler(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法开始");
        this.waiter.sever();
        System.out.println("代理方法结束");
        return null;
    }
}