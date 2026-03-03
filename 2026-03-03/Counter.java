public class Counter {
	private int count;
	private Object object = new Object();

	public int getAndIncrement() {

		System.out.println("loading");
		System.out.println("loading");
		System.out.println("loading");
		System.out.println("loading");
		System.out.println("loading");
		System.out.println("loading");
		System.out.println("loading");
		System.out.println("loading");

		synchronized (this) {
			count = count + 1;
		}
		return count;
	}
}
