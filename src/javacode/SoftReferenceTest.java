package javacode;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用测试
 * @author xuzhangwang
 * @date 2019/8/2
 */
public class SoftReferenceTest {
    static class HeapObject {
        byte[] bs = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        SoftReference<HeapObject> softReference = new SoftReference<HeapObject>(new HeapObject());
        List<HeapObject> list = new ArrayList<>();
        while (true) {
            if (softReference.get() != null) {
                list.add(new HeapObject());
                System.out.println("list.add");
            } else {
                System.out.println("-------软引用被的回收-----------");
                break;
            }
            System.gc();
        }
    }
}
