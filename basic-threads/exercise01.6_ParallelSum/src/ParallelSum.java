import java.util.Random;

public class ParallelSum {
    public static void main(String[] args) {
        int[] numbers = new int[50];
        int partialSums[] = new int[5];
        int sums = 0;
        int checkSums = 0;
        for (int i = 0; i < numbers.length; i++) {
            Random rand = new Random();
            numbers[i] = rand.nextInt(100);
            checkSums += numbers[i];
        }
        SummerThread[] threads = new SummerThread[5];
        for (int i = 0; i < partialSums.length; i++) {
            threads[i] = new SummerThread(i, numbers, partialSums);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int e : partialSums) {
            sums += e;
        }
        System.out.println("Check sum: " + checkSums);
        System.out.println("Calculated sum: " + sums);
    }

}
