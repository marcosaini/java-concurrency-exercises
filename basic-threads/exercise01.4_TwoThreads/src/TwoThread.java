class WorkerThread extends Thread {
    static int counter = 0;
    public void run() {
        System.out.println("Worker thread is running--" + counter++);
    }
}   

class WorkerRunnable implements Runnable {
    public void run() {
        System.out.println("Worker runnable is running.");
    }
}
public class TwoThread {
    public static void main(String[] args){
        Thread thread1 = new WorkerThread();
        Thread thread2 = new Thread(new WorkerRunnable());
        Thread[] threads = new WorkerThread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new WorkerThread();
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        thread1.start();
        thread2.start();
        System.out.println("Hello, World!");
    }
}
