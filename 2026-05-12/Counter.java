public class Counter {
	int x;
	int y;

	public void method1() {
		x += 1; // from the heap
		y += 2;

		// code
		x += 7;

		// // becomes
		// y += 2;
		// x += 1;
		// x += 7;

		// // then
		// y += 2;
		// x += 8;
	}

}
