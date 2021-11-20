package ryoomsae.calandar;

import java.util.Scanner;

public class Prompt {

	
	/**
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = 일요일, 6 = 월요일)
	 * 
	 **/
	public int parseDay(String week) {
		if(week.equals("일")) 
			return 0;
		else if(week.equals("월")) return 1;
		else if(week.equals("화")) return 2;
		else if(week.equals("수")) return 3;
		else if(week.equals("목")) return 4;
		else if(week.equals("금")) return 5;
		else if(week.equals("토")) return 6;
		else return 0;
	}
	
	public void runPrompt() {

		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램.
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2021;
	
		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.println("YEAR> ");
			year = scanner.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("달을 입력하세요.");
			System.out.println("MONTH> ");
			month = scanner.nextInt();
			if (month > 12 || month < 1) {
				System.err.println("잘못된 입력입니다.");
				continue;
			}
			/*
			 * System.out.println("첫째 날의 요일을 입력하세횻"); String strWeekday = scanner.next();
			 * weekDay = parseDay(strWeekday); System.out.println(strWeekday +
			 * ", "+weekDay);
			 */



			cal.printCalendar(year, month);
		}

		System.out.println("+ BYE +");
		scanner.close();

	}

	public static void main(String[] args) {
		// 셀 실행

		Prompt pt = new Prompt();
		pt.runPrompt();

	}

}
