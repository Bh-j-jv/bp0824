package com.tool.rental;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class DayTypeUtil {

	public static boolean isHoliday(LocalDate date) {
		return isIndependenceDay(date) || isLabourDay(date);
	}
	
	public static boolean isIndependenceDay(LocalDate date) {
        // Check if the date is July 4th
        if (date.getMonth() == Month.JULY && date.getDayOfMonth() == 4) {
            return true;
        }
        
        // Check if the observed date for Independence Day
        if (date.getMonth() == Month.JULY) {
            if (date.getDayOfMonth() == 3 && date.getDayOfWeek() == DayOfWeek.FRIDAY) { // July 4th falls on Saturday
                return true;
            }
            if (date.getDayOfMonth() == 5 && date.getDayOfWeek() == DayOfWeek.MONDAY) { // July 4th falls on Sunday
                return true;
            }
        }
        
        return false;
    }

    public static boolean isLabourDay(LocalDate date) {
        // Check if the date is the first Monday of September
        if (date.getMonth() == Month.SEPTEMBER && date.getDayOfWeek() == DayOfWeek.MONDAY) {
            LocalDate firstDayOfMonth = date.withDayOfMonth(1);
            int firstMonday = (firstDayOfMonth.getDayOfWeek() == DayOfWeek.MONDAY) ? 1 : 
                              (9 - firstDayOfMonth.getDayOfWeek().getValue());
            return date.getDayOfMonth() == firstMonday;
        }
        
        return false;
    }

    public static boolean isWeekend(LocalDate date) {
        // Check if the day is between Monday and Friday
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY && dayOfWeek == DayOfWeek.SUNDAY;
    }
}
