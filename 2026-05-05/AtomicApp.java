import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

class AtomicApp {

	void main() throws Exception {

		ExecutorService executor = Executors.newFixedThreadPool(10);
		AtomicInteger atomicCounter = new AtomicInteger(0);

		// 20 iterations vs 22 iterations
		for (int i = 0; i < 20; i++) {
			executor.submit(() -> {
				Boolean pass = false;
				int value, newValue;
				do {
					value = atomicCounter.get();
					newValue = (value * value) + (2 * value) + 1;
					pass = atomicCounter.compareAndSet(value, newValue);
				} while (!pass);
			});

		}

		// wait for the tasks to be finished (i.e. making the main thread
		// joining the pool)
		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

		System.out.println(atomicCounter.get());
	}
}
