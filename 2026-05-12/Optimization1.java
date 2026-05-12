public class Optimization1 {

	// int y; // Main Memory Heap
	// Object obj = new Object(); //Maim Memory - Heap

	// Your code
	public int calculateScore() {
		// int x; //CPU Reg
		// Object obj2 = new Object(); //Maim Memory - Stack

		int base = 50;
		int bonus = 10;
		int multiplier = 2;

		int total = (base + bonus) * multiplier;
		return total;
	}

	// * How the JVM (JIT) optimizes it after warm-up:
	public int calculateScore() {
		return 120; // It pre-calculates the entire block!
	}
}
