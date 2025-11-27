public class Main {
    public static void main(String[] args){
        CounterIf counter = new Counter();

        for(int i=0; i<3; i++){
            Thread tInc = new Thread(new TaskIncrement(counter));
            Thread tDec = new Thread(new TaskDecrement(counter));
            tDec.start();
            tInc.start();
        }
    }
}
