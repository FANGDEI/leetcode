package com.feng.面试题;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/21 13:12
 * @description: {}
 */
public class Solution3 {

    public static int daysBetween(int year1, int month1, int day1, int year2, int month2, int day2) {
        LocalDate date1 = LocalDate.of(year1, month1, day1);
        LocalDate date2 = LocalDate.of(year2, month2, day2);
        long days = ChronoUnit.DAYS.between(date1, date2);
        return (int) days;
    }

    public static void main(String[] args) {
        int days = daysBetween(2010, 5, 1, 2011, 5, 1);
        System.out.println(days); // 输出 365

        days = daysBetween(2011, 5, 1, 2011, 5, 1);
        System.out.println(days); // 输出 0

        days = daysBetween(2011, 5, 1, 2010, 12, 1);
        System.out.println(days); // 输出 -1
    }

}
