package se.liu.malha079.calendar;

import java.util.ArrayList;
import java.util.List;



public class Cal
{
    private List<Appointment> appointments;

    public Cal() {
	this.appointments = new ArrayList<>();
    }

    public void show(){
	for (Appointment appointment : appointments) {
	    System.out.println(appointment);
	    
	}
    }
    public void book(int year, String month, int day, int startHour, int startMinute, int endHour, int endMinute, String subject){
	if ( !(year > 1970)){
	    throw new IllegalArgumentException("felmeddelande");
	}
	if (Month.getDaysInMonth(month) == -1 || Month.getDaysInMonth(month) < day || day < 0){
	    throw new IllegalArgumentException("felmeddelande");
	}
	if (Cal.isTimeIllegal(startHour,startMinute) || Cal.isTimeIllegal(endHour,endMinute)){
	    throw new IllegalArgumentException("felmeddelande");
	}

	TimePoint startTime = new TimePoint(startHour, startMinute);
	TimePoint endTime = new TimePoint(endHour,endMinute);
	TimeSpan meetingSpan = new TimeSpan(startTime,endTime);
	Month meetingMonth = new Month(month);


	SimpleDate meetingDate = new SimpleDate(year, meetingMonth, day);
	Appointment meetingAppointment = new Appointment(subject, meetingDate, meetingSpan);
	appointments.add(meetingAppointment);

    }
    private static boolean isTimeIllegal(int hour, int minute){
	if (hour > 23 || hour < 0){
	    return true;
	}
	if (minute > 59 || minute < 0 ){
	    return true;
	}
	return false;
    }

    public static void main(String[] args) {
	Cal kalender = new Cal();
	kalender.book(2000, "july", 18,22,2,23,30,"Födelsedag");
	kalender.book(1999, "mars", 23,11,15,23,30,"Träning");
	kalender.book(1999, "june", 19,10,2,20,0,"Dans");
	kalender.book(2020, "july", 18,22,2,23,30,"Klappa gris");
	kalender.book(1999, "july", 13,0,0,1,0,"Odla mat");
	kalender.book(2003, "december", 12,22,2,13,30,"handla");
	kalender.book(20000, "july", 18,22,2,23,30,"dansa igen");
	kalender.show();
    }
}
