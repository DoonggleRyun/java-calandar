package ryoomsae.calandar;

import java.util.Scanner;

public class Calandar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printSampleCalendar() {
		System.out.println("�� �� ȭ �� �� �� ��");
		System.out.println("--------------");
		System.out.println("1  2   3   4   5   6  7");
		System.out.println("8  9  10  11  12  13  14");
	}
	
	public static void main(String[] args) {
		// ���ڸ� �Է¹޾� �ش��ϴ� ���� �ִ� �ϼ��� ����ϴ� ���α׷�.
		String PROMPT = "cal> ";
		Scanner scanner = new Scanner(System.in);
		Calandar cal = new Calandar();
		
		System.out.println("�ݺ� Ƚ���� �Է��ϼ���.");
		int repeat = scanner.nextInt();
		
		/*
		 * for (int i = 0; i < repeat; i++) { 
		 * System.out.println("���� �Է��ϼ���.");
		 * System.out.println(PROMPT); int month = scanner.nextInt();
		 * System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�. \n", month,
		 * cal.getMaxDaysOfMonth(month)); 
		 * }
		 */

		int month = 1;
		while (true) {
			 System.out.println("���� �Է��ϼ���.");
			 System.out.println(PROMPT);
			 month = scanner.nextInt();
			 if(month == -1) {
				 break;
			 }
			 if (month > 12) {
				 continue;
			 }
			 System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�. \n", month,cal.getMaxDaysOfMonth(month)); 		
		}
		

	//	cal.printSampleCalendar();
		scanner.close();
	}

}
