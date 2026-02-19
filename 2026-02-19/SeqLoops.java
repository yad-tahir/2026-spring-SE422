public class SeqLoops {
	void main(String... args) {
		loop1();
		loop2();
	}

	long loop1() {
		long i = 0;
		for (; i < 10_000_000; i++) {
			if (i % 10_000 == 0)
				i = 0;
			System.out.println("loop1=" + i);
		}
		return i;
	}

	long loop2() {
		long j = 0;
		for (; j < 10_000_000; j++) {
			if (j % 10_000 == 0)
				j = 0;
			System.out.println("loop2=" + j);
		}
		return j;
	}

}
