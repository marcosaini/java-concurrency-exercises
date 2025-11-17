class Worker extends Thread {
    public void run() {
        System.out.println("Hello from a thread!");
    }
}

public class HelloThread {
    public static void main(String[] args) throws Exception {
        Thread thread = new Worker();
        thread.start();
        System.out.println("Hello, World!");
    }
}
