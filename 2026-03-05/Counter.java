public class Counter {
	private int count;
	private Object cLock = new Object();

	public int getAndIncrement() {
		synchronized (cLock) {
			count = count + 1;
			return count;
		}
	}

	public int getAndDecrement() {
		synchronized (cLock) {
			count = count - 1;
			return count;
		}
	}
}
