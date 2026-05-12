public class ReorderDemo {
	int a = 2;
	boolean flg = false;

	public void method1() {
		a = 1;        // Write to a
		flg = true;   // Then set flag (can be reordered!)
	}

	public void method2() {
		if (flg) {
			// If reordering happened, a might still be 2
			if (a != 1) {
				System.out.println("Reordering observed! a = " + a);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while (true) {
			i++;
			ReorderDemo demo = new ReorderDemo();

			Thread t1 = new Thread(demo::method1);
			Thread t2 = new Thread(demo::method2);

			t1.start();
			t2.start();

			t1.join();
			t2.join();

			if (i % 1000 == 0) {
				System.out.println("Iteration: " + i);
			}
		}
	}
}
