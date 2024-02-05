/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tran Hoang Phuc
 */
public class DatetimeUtil {
    public static Date toDateTime(String s) {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        try {
            Date date = dateFormat.parse(s);
            return date;
        } catch (ParseException e) {
        }
        return new Date();
    }
    
    public static java.sql.Date getFollowingDate(String current) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date currentDate = sdf.parse(current);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            java.sql.Date followingDate = new java.sql.Date(calendar.getTimeInMillis());
            return followingDate;
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception according to your requirements
            return null;
        }
    }
    
    public static String getCurrentSqlDateString() {
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(currentDate);
        return formattedDate;
    }

    public static void main(String[] args) {
        String currentDate = "2024-01-31";
        java.sql.Date followingDate = getFollowingDate(currentDate);
        System.out.println("Current Date: " + currentDate);
        System.out.println("Following Date: " + followingDate);
    }
}
