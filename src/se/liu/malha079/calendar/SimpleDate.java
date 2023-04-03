package se.liu.malha079.calendar;

public class SimpleDate
{
    private int year;
    private Month month;
    private int day;

    public SimpleDate(final int year, final Month month, final int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }

    @Override public String toString() {
	return year + "-" + Month.getMonthNumber(month.getName()) + "-" + day;
    }

    public int getYear() {
	return year;
    }

    public Month getMonth() {
	return month;
    }

    public int getDay() {
	return day;
    }
}

