package version3;

import java.util.Objects;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    public MyDate() {
    }

    public MyDate(int day, int month, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            System.err.println("Invalid day: Must be between 1 and 31.");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            System.err.println("Invalid month: Must be between 1 and 12.");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate() {
        System.out.println(toString());
    }

    private static final String[] MONTH_NAMES = {
        "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    @Override
    public String toString() {
        String monStr = (month >= 1 && month <= 12) ? MONTH_NAMES[month] : String.valueOf(month);
        return String.format("%02d %s %d", day, monStr, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyDate)) return false;

        MyDate other = (MyDate) obj;

        return this.day == other.day 
            && this.month == other.month 
            && this.year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}