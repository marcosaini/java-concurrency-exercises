import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore= new Semaphore(1);
        try {
            semaphore.acquire();
            System.out.println("Semaphore acquired, executing critical section.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
