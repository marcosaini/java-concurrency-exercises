import java.util.Random;

public class TaskDecrement implements Runnable {

    CounterIf counter;

    public TaskDecrement(CounterIf counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            counter.decrement();
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}