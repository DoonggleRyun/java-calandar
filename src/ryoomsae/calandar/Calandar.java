package ryoomsae.calandar;

import java.util.Scanner;

public class Calandar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 != 0))
			return true;
		else
			return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}

	}

	/*
	 * - 월을 입력하면 해당월의 달력을 출력한다. - 달력 모양은 1단계에서 작성한 모양으로 만든다. - 1일은 일요일로 정해도 무방하다. -
	 * 1을 입력받기 전까지 반복 입력 받는다. - 프롬프트별 출력한다.
	 */

	public void printCalendar(int year, int month, int weekDay) {
		System.out.printf("<<       %4d년 %3d월           >> \n", year, month);
		System.out.println("    일   월    화    수   목   금   토");
		System.out.println("-------------------------");

		int maxDay = getMaxDaysOfMonth(year, month);
		int tempMaxDay = maxDay + weekDay;
		for (int i = 1; i <= tempMaxDay; i++) {
			if(i <= weekDay) {
				System.out.print("   ");
			}
			else {
				System.out.printf("%3d", i-weekDay);	
			}
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

}
