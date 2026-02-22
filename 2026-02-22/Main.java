public class Main {
	public static void main(String... args) {

		Info i = new Info();
		i.studentId = 10000;

		Thread t1 = new Thread(() -> {
			while (true) {
				System.out.println("Thread1: " + i.studentId);
				try {
					Thread.sleep(500);
				} catch (Exception _) {
				}
			}
		});

		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					System.out.println("Thread2: " + i.studentId);
					try {
						Thread.sleep(500);
					} catch (Exception _) {
					}
				}
			}
		};

		Thread t3 = new Thread(new Task1(i));

		t1.start();
		t2.start();
		t3.start();
		// t1.run();
	}

}
