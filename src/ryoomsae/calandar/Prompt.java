package ryoomsae.calandar;

import java.util.Scanner;

public class Prompt {

	
	/**
	 * @param week ���ϸ�
	 * @return 0 ~ 6 (0 = �Ͽ���, 6 = ������)
	 * 
	 **/
	public int parseDay(String week) {
		if(week.equals("��")) 
			return 0;
		else if(week.equals("��")) return 1;
		else if(week.equals("ȭ")) return 2;
		else if(week.equals("��")) return 3;
		else if(week.equals("��")) return 4;
		else if(week.equals("��")) return 5;
		else if(week.equals("��")) return 6;
		else return 0;
	}
	
	public void runPrompt() {

		// ���ڸ� �Է¹޾� �ش��ϴ� ���� �ִ� �ϼ��� ����ϴ� ���α׷�.
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2021;
	
		while (true) {
			System.out.println("�⵵�� �Է��ϼ���.");
			System.out.println("YEAR> ");
			year = scanner.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("���� �Է��ϼ���.");
			System.out.println("MONTH> ");
			month = scanner.nextInt();
			if (month > 12 || month < 1) {
				System.err.println("�߸��� �Է��Դϴ�.");
				continue;
			}
			/*
			 * System.out.println("ù° ���� ������ �Է��ϼ���"); String strWeekday = scanner.next();
			 * weekDay = parseDay(strWeekday); System.out.println(strWeekday +
			 * ", "+weekDay);
			 */



			cal.printCalendar(year, month);
		}

		System.out.println("+ BYE +");
		scanner.close();

	}

	public static void main(String[] args) {
		// �� ����

		Prompt pt = new Prompt();
		pt.runPrompt();

	}

}
