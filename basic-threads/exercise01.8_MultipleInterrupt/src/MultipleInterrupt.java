import java.util.Random;

public class MultipleInterrupt {
    public static void main(String[] args){
        Thread threadBusy = new Thread(new ThreadBusy());
        Thread threadSleepy = new Thread(new ThreadSleepy());
        threadBusy.start();
        threadSleepy.start();
        try {
            Thread.sleep(new Random().nextInt(5)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadBusy.interrupt();
        threadSleepy.interrupt();
    }
}
