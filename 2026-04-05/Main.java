import java.util.concurrent.locks.*;

public class Main {
	void main() {
		// Student s1 = new Student();
		// ReentrantLock idLock = new ReentrantLock();
		// ReentrantLock nameLock = new ReentrantLock();

		// Thread t1 = new Thread(() -> {
		// idLock.lock();
		// System.out.println(s1.id);
		// // finally
		// idLock.unlock();
		// });

		// Thread t2 = new Thread(() -> {
		// idLock.lock();
		// s1.id = 20;
		// idLock.unlock();
		// });

		// Thread t3 = new Thread(() -> {
		// nameLock.lock();
		// System.out.println(s1.name);
		// nameLock.unlock();
		// });

		// Thread t4 = new Thread(() -> {
		// nameLock.lock();
		// idLock.lock();
		// System.out.println(s1.name);
		// System.out.println(s1.id);
		// nameLock.unlock();
		// idLock.unlock();
		// });

		// Thread t5 = new Thread(() -> {
		// idLock.lock();
		// nameLock.lock();
		// System.out.println(s1.name);
		// System.out.println(s1.id);
		// idLock.unlock();
		// nameLock.unlock();
		// });

		// t2.start();
		// t1.start();
		// t3.start();

		Student s1 = new Student();
		Student s2 = new Student();

		Thread t1 = new Thread(() -> {
			System.out.println(s1.getId());
			System.out.println(s2.getId());
		});

		Thread t2 = new Thread(() -> {
			s1.setId(20);
		});

		Thread t3 = new Thread(() -> {
			System.out.println(s1.getName());
		});

		Thread t4 = new Thread(() -> {
			System.out.println(s1.getName());
			System.out.println(s1.getId());
		});

		Thread t5 = new Thread(() -> {
			System.out.println(s1.getName());
			System.out.println(s1.getId());
		});

		t2.start();
		t1.start();
		t3.start();
	}
}
