package ryoomsae.calandar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	//검색시엔 해쉬맵
	private HashMap<Date, String> planMap;
	
	
	public void registerPlan(String strDate, String plan) throws ParseException {
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		planMap.put(date, plan);
		
	}
	 
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}
	
	public boolean isLeapYear(int year) {

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}

	}

	/*
	 * - 월을 입력하면 해당월의 달력을 출력한다. - 달력 모양은 1단계에서 작성한 모양으로 만든다. - 1일은 일요일로 정해도 무방하다. -
	 * 1을 입력받기 전까지 반복 입력 받는다. - 프롬프트별 출력한다.
	 */

	public void printCalendar(int year, int month) {
		System.out.printf("<<       %4d년 %3d월           >> \n", year, month);
		System.out.println("    일   월    화    수   목   금   토");
		System.out.println("-------------------------");

		int weekDay = getWeekDay(year, month, 1);
		for (int i = 0; i < weekDay; i++) {
			System.out.print("   ");
		}
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekDay;
		int delim = (count < 7) ? count : 0;

		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim)
				System.out.println();
		}
		System.out.println();
		System.out.println();

		// getWeekDayAuto

//		int weekDay = getWeekDay(year, month, 1);
//		int maxDay = getMaxDaysOfMonth(year, month);
//		int tempMaxDay = maxDay + weekDay;
//		
//		for (int i = 1; i <= tempMaxDay; i++) {
//			if (i <= weekDay) {
//				System.out.print("   ");
//			} else {
//				System.out.printf("%3d", i - weekDay);
//			}
//			if (i % 7 == 0) {
//				System.out.println();
//			}
//		}
//		System.out.println();
//		System.out.println();

	}

	private int getWeekDay(int year, int month, int day) {
		// TODO Auto-generated method stub

//		int sYear = 1970;
		final int STANDARD_WEEKDAY = 4;

		int count = 0;

		for (int i = 1970; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		count += day - 1;
		int weekDay = (count + STANDARD_WEEKDAY) % 7;
		return weekDay;
	}

	public static void main(String[] args) {
		Calendar c = new Calendar();

		System.out.println(c.getWeekDay(1970, 1, 1) == 0);
		System.out.println(c.getWeekDay(1970, 2, 1) == 31);
		System.out.println(c.getWeekDay(1970, 3, 1) == 59);
	}

}
