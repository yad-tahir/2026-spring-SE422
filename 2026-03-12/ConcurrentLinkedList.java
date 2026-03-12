public class ConcurrentLinkedList {

	// A dummy head node makes traversal locking logic much simpler
	private final Node head = new Node(-1);

	/**
	 * Adds @value to the tail of the linked list
	 */
	public void add(int value) {
		Node newNode = new Node(value);

		Node current = head;
		current.lock.lock();

		try {
			while (current.next != null) {
				Node nextNode = current.next;

				// Lock the next node BEFORE releasing the current one
				nextNode.lock.lock();

				// Unlock the node we are leaving behind.
				// [!] THIS IS IMPOSSIBLE WITH SYNCHRONIZED BLOCKS [!]
				current.lock.unlock();

				current = nextNode;
			}

			// tail
			current.next = newNode;
			System.out.println(Thread.currentThread().getName() + " added " + value);
		} finally {
			if (current != null) {
				current.lock.unlock();
			}
		}
	}

	public boolean contains(int target) {
		Node current = head;
		current.lock.lock();

		try {
			while (current.next != null) {
				Node nextNode = current.next;
				nextNode.lock.lock();

				if (nextNode.value == target) {
					System.out.println(Thread.currentThread().getName() + " found " + target);

					current.lock.unlock();

					// Shift 'current' forward so the finally block unlocks the found node
					current = nextNode;

					return true;
				}

				current.lock.unlock();
				current = nextNode;
			}
			return false;
		} finally {
			// This will now correctly unlock the last node we were looking at
			if (current != null) {
				current.lock.unlock();
			}
		}
	}
}
