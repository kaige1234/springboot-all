package cn.com.sk.hello.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * @author sunkai
 * @title: ListTest
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/1619:35
 */
public class ListTest {



    public static void main(String[] args) {
        int currentMaxDays = getCurrentMonthDay();
        int maxDaysByDate = getDaysByYearMonth(2017, 9);

        int sss = getDaysByYear(2017);
        System.out.println("本月天数：" + currentMaxDays);
        System.out.println("2017年9月天数：" + maxDaysByDate);
        System.out.println("2017年9月天数：" + sss);
    }

    /**
     * 获取当月的 天数
     */
    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 根据年 月 获取对应的月份 天数
     */
    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    public static int getDaysByYear(int year) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);

        int maxDate = a.get(Calendar.YEAR);
        return maxDate;
    }

}
