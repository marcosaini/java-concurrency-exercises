import java.util.concurrent.Semaphore;

public class Counter implements CounterIf {
    private static final int MAX_COUNT = 10;
    private static final int MIN_COUNT = 0;

    private Semaphore count;
    private Semaphore mutex;

    public Counter() {
        count = new Semaphore(0);
        mutex = new Semaphore(1);
    }

    @Override
    public void increment() {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count.availablePermits() < MAX_COUNT) {
            count.release();
            System.out.println("Incremented: " + count.availablePermits());
        }
        mutex.release();
    }

    @Override
    public void decrement() {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count.availablePermits() > MIN_COUNT) {
            try {
                count.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Decremented: " + count.availablePermits());
        }
        mutex.release();
    }
}