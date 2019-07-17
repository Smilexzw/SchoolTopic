package basic.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xuzhangwang
 */
public class ReflectSimple {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class rc = Class.forName("basic.reflect.Rebot");
        Rebot r = (Rebot) rc.newInstance();
        System.out.println("Class Name is : " + rc.getName());

        Method getHelo = rc.getDeclaredMethod("torowHello", String.class);
        getHelo.setAccessible(true);
        Object str = getHelo.invoke(r, "Bob");
        System.out.println("getHello result is" + str);

        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r, "welcome ");
    }
}
