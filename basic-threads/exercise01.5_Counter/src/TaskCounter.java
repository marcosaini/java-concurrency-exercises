import java.util.Random;

public class TaskCounter extends Thread {
    private Counter counter;
    private int n;

    public TaskCounter(Counter counter, int n) {
        this.counter = counter;
        this.n = n;
    }

    public int getCount() {
        return counter.getCount();

    }

    public void run() {
        Random random = new Random();
        int iterations = random.nextInt(n/2, n+1);
        for (int i = 0; i < iterations; i++) {
            counter.next();
        }
    }

}
