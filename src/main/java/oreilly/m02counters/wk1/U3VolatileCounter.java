package oreilly.m02counters.wk1;

import oreilly.m02counters.Counter;

/**
 *
 * @author ben
 */
public final class U3VolatileCounter implements Counter {

    private volatile int value = 0;

    public int increment() {
        return value = value + 1;
    }

    public int get() {
        return value;
    }

}
