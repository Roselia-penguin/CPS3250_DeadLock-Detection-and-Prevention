package deadLock;

/**
 * Generates a deadlock scenario using two threads and two locks.
 */

public class DeadlockGeneration {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    /**
     * Thread 1 locks lock1 and waits for lock2, while Thread 2 locks lock2 and waits for lock1
     */
    public static void Generate() {
        Thread thread1 = new Thread(() -> {
            // Acquire lock1
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock 2...");

                // Attempt to acquire lock2
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 and lock 2...");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            // Acquire lock2
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock 1...");

                // Attempt to acquire lock1
                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 1 and lock 2...");
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
