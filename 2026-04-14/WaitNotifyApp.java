public class WaitNotifyApp {
	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource();

		// Producer Thread
		Thread producer = new Thread(() -> {
			String[] messages = { "Hello", "from", "the", "Producer", "DONE" };
			for (String msg : messages) {
				sharedResource.produce(msg);
				try {
					Thread.sleep(1000); // Simulate time taken to produce
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
					Thread.sleep(1500); // Simulate time taken to process the message
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		producer.start();
		consumer.start();
	}
}
