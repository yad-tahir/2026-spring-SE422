//JITOptimazition
public class Optimization3 {

	static final int ITERATIONS = 100_000_000;

	public static void main(String[] args) {
		warmUp();

		long start1 = System.nanoTime();
		deadCodeLoop();
		long end1 = System.nanoTime();
		System.out.println("Dead code loop time: " + (end1 - start1) / 1_000_000 + " ms");

		long start2 = System.nanoTime();
		usedCodeLoop();
		long end2 = System.nanoTime();
		System.out.println("Used code loop time: " + (end2 - start2) / 1_000_000 + " ms");
	}

	// Warming up JVM so JIT has a chance to optimize
	private static void warmUp() {
		for (int i = 0; i < 5; i++) {
			deadCodeLoop();
			usedCodeLoop();
		}
	}

	// Code with dead computation — result is never used
	public static void deadCodeLoop() {
		for (int i = 0; i < ITERATIONS; i++) {
			int x = i * 42; // JIT can eliminate this
		}
	}

	// Code with a used result — JIT cannot eliminate it
	public static void usedCodeLoop() {
		long sum = 0;
		for (int i = 0; i < ITERATIONS; i++) {
			sum += i * 42; // Used result — can't be eliminated
		}
		// Prevent optimization by printing
		if (sum == 0)
			System.out.println("Impossible!");
	}
}
