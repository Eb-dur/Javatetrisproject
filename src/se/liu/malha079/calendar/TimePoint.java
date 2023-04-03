package se.liu.malha079.calendar;

public class TimePoint {

    private int hour;
    private int minute;
    public TimePoint(final int hour, final int minute) {
	this.hour = hour;
	this.minute = minute;
    }

    @Override public String toString() {
	return String.format("%02d:%02d", hour,minute);
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

}
