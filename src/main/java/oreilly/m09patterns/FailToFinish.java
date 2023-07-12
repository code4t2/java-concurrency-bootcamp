package oreilly.m09patterns;

import java.io.Closeable;

public class FailToFinish implements Closeable, Runnable {
    private boolean shutdown = false;

    @Override
    public void close() {
        shutdown = true;
    }

    @Override
    public void run() {
        var i = 0;
        while (!shutdown) {
            System.out.println("Looping... "+ i);
            i += 1;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                shutdown = true;
            }
        }
    }
}
