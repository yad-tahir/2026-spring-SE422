public class Optimization2 {

	private static final boolean DEBUG = false;

	// How you write it:
	public void processData(int data) {
		int unusedVariable = data * 100; // Assigned but never used

		if (DEBUG) {
			// Complex logging logic here
			String logMsg = "Processing data: " + data;
			System.out.println(logMsg);
		}

		System.out.println("Data processed.");
	}

	public void processData(int data) {
		// 'unusedVariable' computation is entirely removed.
		// The 'if (DEBUG)' block is stripped out because DEBUG is false.
		System.out.println("Data processed.");
	}

	void main() {
		for (int i = 0; i < 20000; i++) {
			processData(i);
		}
	}
}
