package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 通过JMX来看一下普通的Java程序有哪些线程
 * @author xuzhangwang
 */
public class MultiThread {
    public static void main(String[] args) {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅仅获取线程和进行堆栈的信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        // 遍历线程信息，仅仅打印线程的ID和线程的名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("["+ threadInfo.getThreadId() +"]" + threadInfo.getThreadName());
        }
    }
}
