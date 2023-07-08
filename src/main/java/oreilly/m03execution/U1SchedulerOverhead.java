package oreilly.m03execution;

public class U1SchedulerOverhead {

    public static void main(String[] args) throws InterruptedException {
        U1SchedulerOverhead so = new U1SchedulerOverhead();
        so.run();
    }

    private void run() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            Thread.sleep(1);
        }
        long end = System.currentTimeMillis();
        System.out.println("Millis elapsed: " + (end - start));
    }
}
