import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class MFence {

	private int data;
	private static final VarHandle DATA_HANDLE;

	static {
		try {
			// Look up the VarHandle for the 'data' field in this class
			DATA_HANDLE = MethodHandles.lookup().findVarHandle(Main.class, "data", int.class);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			// Just in case
			throw new Error(e);
		}
	}

	void setData(int value) {
		// code1
		DATA_HANDLE.fullFence();

		DATA_HANDLE.releaseFence();

		// DATA_HANDLE.acquireFence();
		if (atomic.get() == 2) {
			x = 3;
			y = 4;
			VarHandle.releaseFence();
			sout(z);
		}

		// code2
	}

	void main(String... args) {
	}
}
