package oreilly.m02counters.wk1;

import oreilly.m02counters.Counter;

import java.util.concurrent.atomic.AtomicInteger;

public class U4AtomicCounter implements Counter  {
    private final AtomicInteger internal = new AtomicInteger();

    @Override
    public int increment() {
        return internal.incrementAndGet();
    }

    @Override
    public int get() {
        return internal.get();
    }
}
