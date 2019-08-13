package javacode;

import java.util.concurrent.TimeUnit;

/**
 * 此代码演示两点
 * 1、对象可以在被gc的时候自我拯救
 * 2、这种自我拯救的机会只用一次，因为一个对象的finalize（）方法最多只会倍系统自动调用一次
 * @author xuzhangwang
 * @date 2019/8/2
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive() {
        System.out.println("yes, i am still alive :");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();

        // 因为finalize方法的优先级很低，所以暂停0.5s以等待它
        TimeUnit.MILLISECONDS.sleep(1000);
        if (SAVE_HOOK == null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead : (");
        }


        // 下面的代码的与上面的完全相等，但是这次自救的却失败了
        SAVE_HOOK = null;
        System.gc();

        // 因为finalize方法的优先级很低，所以暂停0.5s以等待它
        TimeUnit.MILLISECONDS.sleep(1000);
        if (SAVE_HOOK == null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead : (");
        }
    }
}
