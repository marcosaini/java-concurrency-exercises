
public class ThreadBusy implements Runnable {

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("child A interrupt");
                break;
            }
        }
    }
}
