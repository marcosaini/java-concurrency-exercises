
public class Producer implements Runnable {
    private CokeMachineIf machine;

    public Producer(CokeMachineIf machine) {
        this.machine = machine;
    }

    @Override
    public void run() {
        while (true) {
            machine.insert();
            try {
                Thread.sleep(5000); // Simulate time taken to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
