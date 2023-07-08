package oreilly.m04locks;

public interface SimpleBoundedQueue<T> {

    void put(T x) throws InterruptedException;

    T take() throws InterruptedException;
}
