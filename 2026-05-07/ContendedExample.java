import jdk.internal.vm.annotation.Contended;

public class ContendedExample {

	public static void main(String[] args) throws InterruptedException {
		var counters = new Counters();

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

class Counters {

	// cache line 1
	@Contended("group1")
	public volatile long counterA = 0L;

	// cache line 2
	@Contended("group2")
	public volatile long counterB = 0L;

}
