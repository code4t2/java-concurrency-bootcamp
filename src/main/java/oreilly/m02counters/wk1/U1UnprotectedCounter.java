package oreilly.m02counters.wk1;

import oreilly.m02counters.Counter;

/**
 *
 * @author ben
 */
public final class U1UnprotectedCounter implements Counter {

    private int i = 0;

    public int increment() {
        return i = i + 1;
    }

    public int get() {
        return i;
    }

}
