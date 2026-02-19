public class TwoModes {
	void main(String... args) {
		if (args.length < 1)
			throw new RuntimeException("An argument is required");

		String mode = args[0].toLowerCase();
		if (mode.equals("loop1"))
			loop1();
		else
			loop2();
	}

	void loop1() {
		for (long i = 0; i < 10_000_000; i++) {
			if (i % 10_000 == 0)
				i = 0;
			System.out.println("loop1=" + i);
		}
	}

	void loop2() {
		for (long j = 0; j < 10_000_000; j++) {
			if (j % 10_000 == 0)
				j = 0;
			System.out.println("loop2=" + j);
		}
	}

}
