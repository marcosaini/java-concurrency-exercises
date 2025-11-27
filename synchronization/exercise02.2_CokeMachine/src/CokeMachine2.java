import java.util.concurrent.Semaphore;

public class CokeMachine2 implements CokeMachineIf {
    private static final int CAPACITY = 10;

    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore counter;

    public CokeMachine2() {
        mutex = new Semaphore(1);
        empty = new Semaphore(0);
        counter = new Semaphore(CAPACITY);
    }

    @Override
    public void remove() {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (counter.availablePermits() > 0) {
            try {
                counter.acquire();
                mutex.release();
                System.out.println("Coke removed. Current count: " + counter.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (counter.availablePermits() == 0) {
            empty.release();
            System.out.println("Coke machine is empty. Signaling for refill.");
        }
    }

    @Override
    public void insert() {
        try {
            empty.acquire();
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter.release(CAPACITY);
        System.out.println("Coke machine refilled. Current count: " + counter.availablePermits());
        mutex.release();
    }
}
