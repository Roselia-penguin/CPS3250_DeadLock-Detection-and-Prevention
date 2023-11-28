package deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {

    public static boolean isDeadlocked() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();

        return threadIds != null && threadIds.length > 0;
    }

    public static void displayDeadlockInformation() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();

        if (threadIds != null && threadIds.length > 0) {
            System.out.println("Deadlock detected!");
            for (long threadId : threadIds) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
                System.out.println("Thread name: " + threadInfo.getThreadName());
                System.out.println("Thread state: " + threadInfo.getThreadState());
                System.out.println("Locks owned by the thread: " + threadInfo.getLockedSynchronizers().length);
            }
        } else {
            System.out.println("No deadlock detected.");
        }
    }
}