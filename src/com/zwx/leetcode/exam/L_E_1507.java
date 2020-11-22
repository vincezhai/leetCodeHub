package com.zwx.leetcode.exam;

public class L_E_1507 {
    public static void main(String[] args) {
        String data = "20th Oct 2052";
        data = "6th Jun 1933";
        System.out.println("f(data) = " + f(data));
    }

    public static String f(String date){
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] str = date.split(" ");
        //year
        String year = str[2];
        //month
        String mon = "";
        for (int i = 0; i <month.length ; i++) {
            if(month[i].equals( str[1] )){
                mon = String.valueOf(i+1);
                break;
            }
        }
        //day
        String day = "";
        for (int i = 0; i < str[0].length(); i++) {
            if( str[0].charAt(i) >= '0' && str[0].charAt(i) <= '9' ){
                day += str[0].charAt(i);
            }
        }

        if(mon.length()==1){
            mon = "0"+mon;
        }
        if(day.length()==1){
            day = "0"+day;
        }
        return year+"-"+mon+"-"+day;
    }
}
