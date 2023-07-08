package oreilly.m02counters;

import oreilly.m02counters.wk1.*;

/**
 * @author ben
 */
public class CounterMain {
    public static final int REPS = 10_000_000;

    public static void main(String[] args) throws InterruptedException {
        final var c = new HalfSynchronizedCounter();

        Runnable r = () -> {
            for (int i = 0; i < REPS; i = i + 1) {
                c.increment();
            }
        };

        Thread tA = new Thread(r);
        Thread tB = new Thread(r);
        long start = System.currentTimeMillis();
        tA.start();
        tB.start();
        tA.join();
        tB.join();
        long fin = System.currentTimeMillis();
        int lost = 2 * REPS - c.get();
        System.out.println(c.getClass().getSimpleName() + " lost " + lost + " updates");
        System.out.println(c.getClass().getSimpleName() + " took " + (fin - start) + " ms");
    }

}
