public class DeadLockExample {
	final Object lock1 = new Object();
	final Object lock2 = new Object();

	void main() {
		Thread t1 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("Thread 1: Holding lock 1...");
				// To simulate CS1
				try {
					Thread.sleep(100);
				} catch (Exception _) {
				}

				System.out.println("Thread 1: Request lock 2...");
				// CS2
				synchronized (lock2) {
					System.out.println("Thread 1: Acquired lock 2.");
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (lock2) {
				System.out.println("Thread 2: Holding lock 2...");
				// To simulate CS1
				try {
					Thread.sleep(100);
				} catch (Exception _) {
				}

				System.out.println("Thread 2: Request lock 1...");
				// CS2
				synchronized (lock1) {
					System.out.println("Thread 2: Acquired lock 1.");
				}
			}
		});

		t1.start();
		t2.start();
	}

}
