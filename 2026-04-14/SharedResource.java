class SharedResource {
	private String message;
	private boolean hasMessage = false;

	// Send a message
	public synchronized void produce(String msg) {
		// this
		while (hasMessage) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}

		this.message = msg;
		this.hasMessage = true;
		System.out.println("Produced: " + msg);

		this.notify();
	}

	// Read the message
	public synchronized String consume() {
		while (!hasMessage) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}

		this.hasMessage = false;
		System.out.println("Consumed: " + message);

		notify();

		return message;
	}
}
