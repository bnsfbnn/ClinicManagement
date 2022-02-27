/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class include utility methods
 *
 * @author Thanh Tung
 */
public class Utils {

    /**
     * - Get today date
     *
     * @return a <code>String</code> objects.
     */
    public static String getToday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(new Date());
        return date;
    }

    public static String parseDateFormat(String date) {
        String[] dateAttrArray = date.split("/");
        return dateAttrArray[2] + '-' + dateAttrArray[0] + '-' + dateAttrArray[1];
    }

    public static String revertParseDateFormat(String date) {
        String[] dateAttrArray = date.split("-");
        return dateAttrArray[1] + '/' + dateAttrArray[2] + '/' + dateAttrArray[0];
    }

    public static String getMondayOfThisWeek() {
        LocalDate today = LocalDate.now();
        // Go backward to get Monday
        LocalDate monday = today;
        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
            monday = monday.minusDays(1);
        }
        return monday.toString();
    }

    public static String getSundayOfThisWeek() {
        LocalDate today = LocalDate.now();
        // Go forward to get Sunday
        LocalDate sunday = today;
        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
            sunday = sunday.plusDays(1);
        }
        return sunday.toString();
    }

    public static ArrayList<String> getDayOfThisWeek(String viewDay) {
//        LocalDate today = LocalDate.of(viewDay);
//        System.out.println(today);
//        // Go backward to get Monday
//        LocalDate monday = today;
//        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
//            monday = monday.minusDays(1);
//        }
//        int count = 0;
//        ArrayList<String> dayOfWeek = new ArrayList<>();
//        while(count<7){
//            dayOfWeek.add(monday.toString());
//            monday = monday.plusDays(1);
//            count++;
//        }
//        return dayOfWeek;
        return null;
    }
}
