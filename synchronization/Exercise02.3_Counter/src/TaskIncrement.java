import java.util.Random;

public class TaskIncrement implements Runnable{
    CounterIf counter;
    public TaskIncrement(CounterIf counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while(true){
            counter.increment();
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
