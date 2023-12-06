package deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import ui.DeadLockDetectPage;

public class DeadlockDetector {

    public static String resultString;

    public static boolean isDeadlocked() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();

        return threadIds != null && threadIds.length > 0;
    }

    public static void displayDeadlockInformation() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();

        resultString = "";
        if (threadIds != null && threadIds.length > 0) {

            ThreadInfo[] info = threadMXBean.getThreadInfo(threadIds);
            for (ThreadInfo threadInfo : info) {
                resultString = "\nDeadlock detected!" +
                        "\nThread name: " + threadInfo.getThreadName() +
                        "\nThread state: " + threadInfo.getThreadState() +
                        "\nLocks owned by the thread: " + threadInfo.getLockOwnerName() + "\n";
                DeadLockDetectPage.resultArea.append(DeadlockDetector.resultString);
            }
        } else {
            //System.out.println("No deadlock detected.");
            resultString = ("No deadlock detected.");
        }
        System.out.println(resultString);
    }
}