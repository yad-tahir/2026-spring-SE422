import java.util.concurrent.*;

public class Pool {

	void main() {

		// visualvm
		int availableCores = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(availableCores + 1);

		for (int i = 0; i < 10_000; i++) {
			SomeTask toRun = new SomeTask();
			executor.submit(toRun);
		}
	}
}
