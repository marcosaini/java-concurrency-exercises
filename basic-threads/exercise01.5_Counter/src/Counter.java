public class Counter {
    private int count = 0;

    public static void main(String[] args) {
        TaskCounter taskCounter = new TaskCounter(new Counter(), 1000);
        taskCounter.start();
        try {
            taskCounter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count: " + taskCounter.getCount());
    }

    public void next() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
