import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class SharedState {
	private int counter = 0;

	private static final VarHandle COUNTER_HANDLE;

	static {
		try {
			COUNTER_HANDLE = MethodHandles.lookup()
					.findVarHandle(SharedState.class, "counter", int.class);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public void writeSequentially(int newValue) {
		// Enforces StoreStore, LoadStore, and StoreLoad fences
		COUNTER_HANDLE.setVolatile(this, newValue);
	}

	public int readSequentially() {
		// Enforces LoadLoad and LoadStore fences
		return (int) COUNTER_HANDLE.getVolatile(this);
	}

	// Sequentially Consistent Read-Modify-Write
	public boolean compareAndSwap(int expected, int newValue) {
		return COUNTER_HANDLE.compareAndSet(this, expected, newValue);
	}
}
