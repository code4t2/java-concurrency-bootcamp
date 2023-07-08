package oreilly.m04locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class U2JUCQueue<T> implements SimpleBoundedQueue<T> {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final T[] items = (T[]) new Object[100];
    private int putPtr, takePtr, count;

    public void put(T x) throws InterruptedException {
        lock.lock();
        try {
            // If full, release lock & wait until we get it back
            while (count == items.length) {
                notFull.await();
            }

            items[putPtr] = x;
            if (++putPtr == items.length) putPtr = 0;
            count += 1;

            // signal notEmpty that it can try for the lock again
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            // If empty, release the lock & wait
            while (count == 0) {
                notEmpty.await();
            }

            T x = items[takePtr];
            if (++takePtr == items.length) takePtr = 0;
            count -= 1;

            // Signal notFull that it can stop waiting & try for the lock
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
