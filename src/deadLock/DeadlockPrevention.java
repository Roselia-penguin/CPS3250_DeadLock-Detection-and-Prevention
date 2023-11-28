package deadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockPrevention {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void execute() {
        Thread thread1 = new Thread(this::operation1);
        Thread thread2 = new Thread(this::operation2);

        thread1.start();
        thread2.start();
    }

    private void operation1() {
        lock1.lock();
        try {
            // Do something
            lock2.lock();
            try {
                // Do something
            } finally {
                lock2.unlock();
            }
        } finally {
            lock1.unlock();
        }
    }

    private void operation2() {
        lock2.lock();
        try {
            // Do something
            lock1.lock();
            try {
                // Do something
            } finally {
                lock1.unlock();
            }
        } finally {
            lock2.unlock();
        }
    }
}
