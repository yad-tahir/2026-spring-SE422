import java.util.Scanner;
import java.util.*;
import module java.base;

public class ITE202 {
	void main() {

		var z = 200;
		var scanner = new Scanner(System.in);
		// var tmp = generateTemp();

		short x;
		x = (short) 200000;

		long y = 200000000l;

		long phone = 07707012345l; // octa
		long number2 = 0xffaa; // hexa

		// System.out.println("Hello world " + x);
		// System.out.println("Hello world " + y);
		System.out.println(phone);
		System.out.println(number2);

		if (phone == 1) {
			// true
		} else {
			// false
			System.out.println("false");
			System.out.println("bye");
		}

		int value = 2;
		// int result = 0;
		// switch(value){
		// case 1:
		// result = 10;
		// break;
		// case 2:
		// result = 20;
		// break;
		// default:
		// result = -1;
		// }

		int result = switch (value) {
			case 1 -> 10;
			case 2 -> 20;
			default -> -1;
		};
	}
}
