class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }
}

public class HelloThread {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Worker());
        thread.start();
        thread.join(); // Wait for the thread to finish
        System.out.println("Hello, World!");
    }
}
