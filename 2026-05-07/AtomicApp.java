import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

class AtomicApp {

	void main() throws Exception {
		var b = new AtomicBoolean();
		var ref = new AtomicReference<String>();

		var l = new AtomicLong();
		var adder = new LongAdder();
		adder.add(200);
		adder.add(-20);

		adder.sum();

	}
}
