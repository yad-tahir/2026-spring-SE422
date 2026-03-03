public class SequentialApp {
	void main() {
		Counter counter = new Counter();

		while (true) {
			int num = counter.getAndIncrement();
			System.out.println("Processing: " + num);
		}
	}
}
