package ryoomsae.calandar;

import java.util.Scanner;

public class Calandar {

	public static void main(String[] args){
		System.out.println("hello");
		
		
		// ���ڸ� �Է¹޾� �ش��ϴ� ���� �ִ� �ϼ��� ����ϴ� ���α׷�.
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �Է��ϼ���.");
		int month = scanner.nextInt();
		int[] maxDays = {31, 28, 30, 31};
		System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�. \n", month, maxDays[month-1]);
		scanner.close();
	}

}
