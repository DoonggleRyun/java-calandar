package ryoomsae.calandar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		// �Է��� Ű����
		// ����� ȭ�鿡 �� ���� ���� ����մϴ�.
		int a, b;

		Scanner scanner = new Scanner(System.in);
		String s1, s2;
		System.out.println("s1 �Է�");
		s1 = scanner.next();
		System.out.println("s2 �Է�");
		s2 = scanner.next();

		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		// System.out.println(s1+" ,"+s2);

		System.out.println(s1 + " + " + s2 + " = " + (a + b));
		System.out.printf(" %d ��  %d��  ���� %d �Դϴ�.", a, b,  a+b);
		scanner.close();
	}
}
