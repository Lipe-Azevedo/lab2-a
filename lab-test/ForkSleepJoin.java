import java.util.Random;
import java.util.concurrent.Semaphore;

public class ForkSleepJoin {
    static Semaphore semJoin = new Semaphore(0);

    static class ChildTask implements Runnable {
        public void run() {
            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(6);
                Thread.sleep(sleepTime * 1000);
                semJoin.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) return;
        int n = Integer.parseInt(args[0]);

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new ChildTask());
            threads[i].start();
        }

        try {
            for (int i = 0; i < n; i++) {
                semJoin.acquire();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(n);
    }
}