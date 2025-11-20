public class Interrupt {
    public static void main(String[] args){
        ChildThread child = new ChildThread();
        child.start();
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Main thread is interrupting child thread...");
        child.interrupt();
    }
}
