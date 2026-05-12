public class Optimization1 {

	// Your code
	public int calculateScore() {

		int base = 50;
		int bonus = 10;
		int multiplier = 2;

		int total = (base + bonus) * multiplier;
		return total;
	}

	// How the JVM (JIT) optimizes it after warm-up:
	public int calculateScore() {
		return 120; // It pre-calculates the entire block!
	}
}
