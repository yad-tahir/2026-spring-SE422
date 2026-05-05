import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

class App {
	public static void main(String... args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		AtomicInteger atomicCounter = new AtomicInteger(0);

		for (int i = 0; i < 1000; i++) {
			executor.submit(() -> {
				// atomicCounter.incrementAndGet(); // ++count
				// atomicCounter.incrementAndGet(); // ++count

				atomicCounter.addAndGet(2);
				atomicCounter.addAndGet(2);
				// result = 101
			});
		}
	}
}
