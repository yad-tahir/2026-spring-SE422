public class NonContendedExample {

	public static void main(String[] args) throws InterruptedException {
		var counters = new BasicCounters();

		Thread thread1 = new Thread(() -> {
			for (long i = 0; i < 100_000_000L; i++) {
				counters.counterA++;
			}
		});

		Thread thread2 = new Thread(() -> {
			for (long i = 0; i < 100_000_000L; i++) {
				counters.counterB++;
			}
		});

		long startTime = System.currentTimeMillis();

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		long endTime = System.currentTimeMillis();

		System.out.println("Counter A: " + counters.counterA);
		System.out.println("Counter B: " + counters.counterB);
		System.out.println("Time taken: " + (endTime - startTime) + " ms");
	}
}

class BasicCounters {

	public volatile long counterA = 0L;

	public volatile long counterB = 0L;

}
