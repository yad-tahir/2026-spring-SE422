import java.util.concurrent.locks.*;

public class JoinMain {
	public static void main(String[] args) {
		Thread workerThread = new Thread(() -> {
			try {
				// Simulate a time-consuming task by sleeping for 3 seconds
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Worker Thread: Interrupted!");
			}

			System.out.println("Worker Thread: Finished the work!");
		});

		System.out.println("Main Thread: Starting the worker");
		workerThread.start();

		while (workerThread.isAlive()) {
			try {
				workerThread.join();
			} catch (InterruptedException e) {
				System.out.println("Main Thread: Interrupted while waiting.");
			}
		}

		System.out.println("Main Thread: Worker thread is done. Main thread is resuming and ending.");
	}
}
