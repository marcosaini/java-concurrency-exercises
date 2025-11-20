
public class ThreadBusy implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("child A interrupt");
                break;
            }
        }
    }
}
