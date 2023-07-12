package oreilly.m09patterns;

public class FailToFinishMain {

    public static void main(String[] args) throws InterruptedException {
        Thread t;
        try (var f2f = new FailToFinish()) {
            t = new Thread(f2f);
            t.start();
            Thread.sleep(500);
        }
        t.join();
    }

}
