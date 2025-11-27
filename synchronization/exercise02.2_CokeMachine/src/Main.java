public class Main {
    public static void main(String[] args) throws Exception {
        //CokeMachineIf machine = new CokeMachine();
        //CokeMachineIf machine = new CokeMachine1();
        CokeMachineIf machine = new CokeMachine2();
        Thread producer = new Thread(new Producer(machine));
        producer.start();
        for (int i = 0; i < 5; i++) {
            Thread consumer = new Thread(new Consumer(machine));
            consumer.start();
        }
    }
}
