package oreilly.m04locks;

public class U1ClassicQueue<T> implements SimpleBoundedQueue<T> {

    private final T[] items = (T[]) new Object[100];
    private int putPtr, takePtr, count;

    public synchronized void put(T x) throws InterruptedException {
        // If full, release lock & wait until we get it back
        while (count == items.length) {
            System.out.println("Queue full");
            wait();
        }

        items[putPtr] = x;
        if (++putPtr == items.length) putPtr = 0; // ring buffer condition
        count += 1;

        // signal other threads that they can try for the lock again
        notify();
    }

    public synchronized T take() throws InterruptedException {
        // If empty, release the lock & wait
        while (count == 0) {
            System.out.println("Queue empty");
            wait();
        }

        T x = items[takePtr];
        if (++takePtr == items.length) takePtr = 0; // ring buffer condition
        count -= 1;

        // Signal other threads that they can stop waiting & try for the lock
        notify();
        return x;
    }
}
