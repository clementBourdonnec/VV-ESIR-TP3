package fr.istic.vv;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) throws Exception{
        if(!isValidDate(day,month,year))
            throw  new Exception("Error Invalid Date");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        String date = "";
        date+=day+"-";
        date+=month+"-";
        date+=year;
        try {
            DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    public Date nextDate() throws Exception{
        if(isValidDate(day+1,month, year)){
            return new Date(day+1,month, year);
        }
        else if (isValidDate(01,month+1,year)){
            return new Date(01,month+1, year);
        }
        else{
            return new Date(01,01,year+1);
        }
    }

    public Date previousDate() throws Exception{
        if(isValidDate(day-1,month, year)){
            return new Date(day-1,month, year);
        }
        else if (isValidDate(31,month-1,year)){
            return new Date(31,month-1, year);
        }
        else{
            return new Date(31,12,year-1);
        }
    }

    public int compareTo(Date other){
        if(other == null)throw new NullPointerException();

        if(this.year>other.year)return 1;

        else if(this.year<other.year)return -1;

        else{
            if(this.month>other.month)return 1;

            else if(this.month<other.month)return -1;

            else{
                if(this.day>other.day)return 1;
                else if(this.day<other.day)return -1;
                else return 0;
            }
        }
    }

}