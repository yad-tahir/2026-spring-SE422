public class Task1 implements Runnable {

	Info obj;

	public Task1(Info arg) {
		obj = arg;
	}

	public void run() {
		while (true) {
			System.out.println("Thread3: " + obj.studentId);
			obj.studentId += 1;
			try {
				Thread.sleep(500);
			} catch (Exception ex) {
			}
		}
	}
}
