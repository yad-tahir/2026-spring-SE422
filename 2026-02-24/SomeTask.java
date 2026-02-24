import java.util.Random;

public class SomeTask implements Runnable {
	int id;

	public SomeTask() {
		Random r = new Random();
		id = r.nextInt(0, Short.MAX_VALUE);
	}

	public void run() {
		for (int i = 0; i < id; i++) {
			System.out.println("Job " + id + ": executed");
			try {
				Thread.sleep(50);
			} catch (Exception _) {
			}
		}

	}
}
