package deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import ui.DeadLockDetectPage;

/**
 * Displays information about deadlocks.
 * Uses ThreadMXBean to find deadlocked threads and prints relevant information.
 */
public class DeadlockDetector {

    public static String resultString;

    public static Boolean isDeadLock;

    public static void displayDeadlockInformation() {
        isDeadLock = false;

        // Monitoring thread information
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // Find IDs of threads that are deadlocked
        long[] threadIds = threadMXBean.findDeadlockedThreads();

        resultString = "";
        if (threadIds != null && threadIds.length > 0) {
            isDeadLock = true;
            ThreadInfo[] info = threadMXBean.getThreadInfo(threadIds);
            for (ThreadInfo threadInfo : info) {
                resultString = "\nDeadlock detected!" +
                        "\nThread name: " + threadInfo.getThreadName() +
                        "\nThread state: " + threadInfo.getThreadState() +
                        "\nLocks owned by the thread: " + threadInfo.getLockOwnerName() + "\n";

                // Append the result string to the GUI
                DeadLockDetectPage.resultArea.append(DeadlockDetector.resultString);
            }
        } else {
            //System.out.println("No deadlock detected.");
            resultString = ("\nNo deadlock detected.\n");
            DeadLockDetectPage.resultArea.append(DeadlockDetector.resultString);
        }
        System.out.println(resultString);
    }
}