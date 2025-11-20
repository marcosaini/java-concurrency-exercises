public class Interrupt {
    public static void main(String[] args) {
        ChildThread child = new ChildThread();
        child.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is interrupting child thread...");
        child.interrupt();
    }
}
