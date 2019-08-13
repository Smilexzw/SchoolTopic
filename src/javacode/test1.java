package javacode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuzhangwang
 * @date 2019/7/24
 */
public class test1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class<methodClass> clazz = methodClass.class;
//        Object object = clazz.newInstance();
//        // 获取的methodClass类的方法
//        Method add = clazz.getMethod("add", int.class, int.class);
//
//        Object result = add.invoke(object, 1, 4);
//        System.out.println(result);


        Class<methodClass> clazz = methodClass.class;
        Constructor<methodClass> c = clazz.getConstructor(int.class);
        methodClass me = c.newInstance(3);
        System.out.println(me.getI());
        int add = me.add(1, 2);
        System.out.println(add);
        Object object = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }
}

class methodClass {

    private int i;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public methodClass() {}

    public methodClass(int i) {
        this.i = i;
    }

    private final int fuck = 3;

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}
