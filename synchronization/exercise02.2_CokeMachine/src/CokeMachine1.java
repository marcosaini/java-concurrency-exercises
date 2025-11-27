import java.util.concurrent.Semaphore;

public class CokeMachine1 implements CokeMachineIf {
	private static final int CAPACITY = 10;
	private int count;
	private Semaphore mutex;
	private Semaphore empty;
	private boolean isProdeucerNotified;

	public CokeMachine1() {
		this.count = CAPACITY;
		mutex = new Semaphore(1);
		empty = new Semaphore(0);
		isProdeucerNotified = false;
	}

	@Override
	public void remove() {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (count > 0) {
			count--;
			System.out.println("Coke removed. Current count: " + count);
		}
		if (count == 0 && !isProdeucerNotified) {
			isProdeucerNotified = true;
			empty.release();
			System.out.println("Coke machine is empty. Signaling for refill.");
		}
		mutex.release();
	}

	@Override
	public void insert() {
		try {
			empty.acquire();
			mutex.acquire();
			count = CAPACITY;
			isProdeucerNotified = false;
			System.out.println("Coke machine refilled. Current count: " + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}
	}

}