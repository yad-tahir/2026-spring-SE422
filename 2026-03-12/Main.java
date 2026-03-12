public class Main {
	public static void main(String[] args) {
		ConcurrentLinkedList list = new ConcurrentLinkedList();

		// Thread 1 adds a bunch of data
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				list.add(i);
			}
		}, "Writer Thread");

		// Thread 2 searches for data while Thread 1 is writing
		Thread t2 = new Thread(() -> {
			list.contains(3);
		}, "Reader Thread");

		t1.start();
		t2.start();
	}
}
