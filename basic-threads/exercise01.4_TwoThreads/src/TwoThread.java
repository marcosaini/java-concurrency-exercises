class WorkerThread extends Thread {
    public void run() {
        System.out.println("Worker thread is running.");
    }
}   

class WorkerRunnable implements Runnable {
    public void run() {
        System.out.println("Worker runnable is running.");
    }
}
public class TwoThread {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new WorkerThread();
        Thread thread2 = new Thread(new WorkerRunnable());
        thread1.start();
        thread2.start();
        System.out.println("Hello, World!");
    }
}
