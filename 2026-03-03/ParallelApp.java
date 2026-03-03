public class ParallelApp {

	void main() {
		Counter counter = new Counter();

		for (int i = 0; i < 40; i++) {
			new Thread(() -> {
				while (true) {
					int num = counter.getAndIncrement();
					System.out.println(Thread.currentThread().getName() +
							" Processing: " + num);
				}
			}).start();
		}

	}
}
