import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Node {
	public int value;
	public Node next;

	// We MUST use ReentrantLock. Synchronized blocks cannot achieve our traversal
	// logic.
	public final Lock lock;

	public Node(int value) {
		this.value = value;
		this.lock = new ReentrantLock();
	}
}
