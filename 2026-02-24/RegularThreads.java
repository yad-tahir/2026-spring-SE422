public class RegularThreads {
	void main() {
		for (int i = 0; i < 10_000; i++) {
			SomeTask toRun = new SomeTask();
			Thread t = new Thread(toRun);
			t.start();
		}

	}
}
