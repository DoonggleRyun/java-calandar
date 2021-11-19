package ryoomsae.calandar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		// 입력은 키보드
		// 출격은 화면에 두 수의 합을 출력합니다.
		int a, b;

		Scanner scanner = new Scanner(System.in);
		String s1, s2;
		System.out.println("s1 입력");
		s1 = scanner.next();
		System.out.println("s2 입력");
		s2 = scanner.next();

		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		// System.out.println(s1+" ,"+s2);

		System.out.println(s1 + " + " + s2 + " = " + (a + b));
		System.out.printf(" %d 와  %d의  합은 %d 입니다.", a, b,  a+b);
		scanner.close();
	}
}
