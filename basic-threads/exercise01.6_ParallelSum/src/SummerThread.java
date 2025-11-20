
public class SummerThread extends Thread {

    private int[] partialSums;
    private int[] numbers;
    private int index;

    public SummerThread(int index, int[] numbers, int[] partialSums) {
        this.index = index;
        this.numbers = numbers;
        this.partialSums = partialSums;
    }

    public void run() {
        for (int i=0; i<10; i++){
            partialSums[index] += numbers[index * 10 + i];
        }
        System.out.println("Partial sum " + index + ": " + partialSums[index]);
    }

}
