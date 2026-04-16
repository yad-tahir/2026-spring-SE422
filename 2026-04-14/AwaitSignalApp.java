public class AwaitSignalApp {
	public static void main(String[] args) {
		SharedResourceReentrantLock sharedResource = new SharedResourceReentrantLock();

		// Producer Thread
		Thread producer = new Thread(() -> {
			String[] messages = { "Locks", "give", "you", "more", "DONE" };
			for (String msg : messages) {
				sharedResource.produce(msg);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		// Consumer Thread
		Thread consumer = new Thread(() -> {
			String receivedMessage = "";
			while (!"DONE".equals(receivedMessage)) {
				receivedMessage = sharedResource.consume();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		producer.start();
		consumer.start();
	}
}
