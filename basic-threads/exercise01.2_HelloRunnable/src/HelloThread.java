class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from the worker thread!");
    }
}

public class HelloThread {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Worker());
        thread.start();
        System.out.println("Hello, World!");
    }
}

