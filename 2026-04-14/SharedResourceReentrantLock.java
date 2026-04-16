import java.util.concurrent.locks.*;

// The shared resource using explicit locks
class SharedResourceReentrantLock {
	private String message;
	private boolean hasMessage = false;

	private final Lock lock = new ReentrantLock();

	private final Condition notFull = lock.newCondition(); // For the Producer
	private final Condition notEmpty = lock.newCondition(); // For the Consumer

	public void produce(String msg) {
		lock.lock(); // Acquire the lock
		try {
			while (hasMessage) {
				notFull.await();
			}

			this.message = msg;
			this.hasMessage = true;
			System.out.println("Produced: " + msg);

			// Signal the consumer that the buffer is now not empty
			notEmpty.signal();

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Producer interrupted");
		} finally {
			lock.unlock();
		}
	}

	// Method for the Consumer
	public String consume() {
		lock.lock(); // Acquire the lock
		try {
			while (!hasMessage) {
				// Buffer is empty; wait until the producer signals it is not empty
				notEmpty.await();
			}

			this.hasMessage = false;
			System.out.println("Consumed: " + message);

			notFull.signal();

			return message;

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Consumer interrupted");
			return null;
		} finally {
			lock.unlock();
		}
	}
}
