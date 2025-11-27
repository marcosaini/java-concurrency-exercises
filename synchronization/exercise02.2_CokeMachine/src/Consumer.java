
public class Consumer implements Runnable {
    private CokeMachineIf machine;

    public Consumer(CokeMachineIf machine) {
        this.machine = machine;
    }

    @Override
    public void run() {
        while (true) {
            machine.remove();
            try {
                Thread.sleep(2000); // Simulate time taken to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
