package ryoomsae.calandar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	
	public void printMenue() {
		System.out.println("---------------------");
		System.out.println("1. �������");
		System.out.println("2. ���� �˻�");
		System.out.println("3. �޷º���");
		System.out.println("h. ����");		
		System.out.println("q. ����");
		System.out.println("---------------------");		
	}
	
	
	
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
	
	/*
	 * 1. ������� 2. ���� �˻� 3. �޷º���  h. ���� q. ���� ���( 1, 2, 3, h, q)
	 */
	public void runPrompt() throws ParseException {

		printMenue();
		// ���ڸ� �Է¹޾� �ش��ϴ� ���� �ִ� �ϼ��� ����ϴ� ���α׷�.
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		while (true) {
			System.out.println("���( 1, 2, 3, h, q)");
			String cmd = scanner.next();
			if(cmd.equals("1")) cmdRegister(scanner, cal);
			else if (cmd.equals("2")) cmdSearch(scanner, cal); 
			else if (cmd.equals("3")) cmdCal(scanner, cal);
			else if (cmd.equals("h")) printMenue();
			else if (cmd.equals("q")) break;
		}

		System.out.println("+ BYE +");
		scanner.close();

	}
	
	private void cmdCal(Scanner s, Calendar c) {
		// TODO Auto-generated method stub
		int month = 1;
		int year = 2021;

		System.out.println("�⵵�� �Է��ϼ���.");
		System.out.println("YEAR> ");
		year = s.nextInt();

		System.out.println("���� �Է��ϼ���.");
		System.out.println("MONTH> ");
		month = s.nextInt();
		
		if (month > 12 || month < 1) {
			System.err.println("�߸��� �Է��Դϴ�.");
			return;
		}
	
		c.printCalendar(year, month);	

	}



	private void cmdSearch(Scanner scanner, Calendar cal) {
		System.out.println("[���� �˻�]");
		System.out.println("��¥�� �Է��� �ּ��� (yyyy-MM-dd).");
		String date = scanner.next();
		String plan = "";
		try {
			plan = cal.searchPlan(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("���� �˻� �� ������ �߻��߽��ϴ�.");
		}
		System.out.println(plan);
	}



	private void cmdRegister(Scanner scanner, Calendar cal) throws ParseException {
		System.out.println("[new ���� ���]");
		System.out.println("��¥�� �Է��� �ּ��� (yyyy-MM-dd).");
		String date = scanner.next();
		System.out.println("������ �Է����ּ���.(������ ���� ;�� �Է��� �ּ���.)");
		String text = scanner.nextLine();
		while(true) {
			String word = scanner.next();
			text += word + " ";
			if(word.endsWith(";")) {
				break;
			}
		}
		cal.registerPlan(date, text);
	}



	public static void main(String[] args) throws ParseException {
		// �� ����

		Prompt pt = new Prompt();
		pt.runPrompt();

	}

}
