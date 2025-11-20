
public class ChildThread extends Thread {
    long time= System.currentTimeMillis();
    @Override
    public void run() {
        try {
                System.out.println("Child thread is running...");
                Thread.sleep(10000);
                System.out.println("Child thread completed after "+(System.currentTimeMillis()-time)+" ms");
        } catch (InterruptedException e) {
            System.out.println("Child thread is interrupted after "+(System.currentTimeMillis()-time)+" ms");
        }
    }

}
