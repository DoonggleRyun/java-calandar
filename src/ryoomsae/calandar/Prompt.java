package ryoomsae.calandar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	
	public void printMenue() {
		System.out.println("---------------------");
		System.out.println("1. 일정등록");
		System.out.println("2. 일정 검색");
		System.out.println("3. 달력보기");
		System.out.println("h. 도움말");		
		System.out.println("q. 종료");
		System.out.println("---------------------");		
	}
	
	
	
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
	
	/*
	 * 1. 일정등록 2. 일정 검색 3. 달력보기  h. 도움말 q. 종료 명령( 1, 2, 3, h, q)
	 */
	public void runPrompt() throws ParseException {

		printMenue();
		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램.
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		while (true) {
			System.out.println("명령( 1, 2, 3, h, q)");
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

		System.out.println("년도를 입력하세요.");
		System.out.println("YEAR> ");
		year = s.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.println("MONTH> ");
		month = s.nextInt();
		
		if (month > 12 || month < 1) {
			System.err.println("잘못된 입력입니다.");
			return;
		}
	
		c.printCalendar(year, month);	

	}



	private void cmdSearch(Scanner scanner, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		String plan = "";
		try {
			plan = cal.searchPlan(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);
	}



	private void cmdRegister(Scanner scanner, Calendar cal) throws ParseException {
		System.out.println("[new 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		System.out.println("일정을 입력해주세요.(문장의 끝에 ;을 입력해 주세요.)");
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
		// 셀 실행

		Prompt pt = new Prompt();
		pt.runPrompt();

	}

}
