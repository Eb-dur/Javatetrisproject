package se.liu.malha079.calendar;

import java.util.Map;

public class Month
{
    private static final Map<String,Integer> MONTH_NAME_TO_LENGTH = Map.ofEntries(
            Map.entry("january", 31),
            Map.entry("february", 28),
            Map.entry("mars", 31),
            Map.entry("april", 30),
            Map.entry("may", 31),
            Map.entry("june", 30),
            Map.entry("july", 31),
            Map.entry("august", 31),
            Map.entry("september", 30),
            Map.entry("october", 31),
            Map.entry("november", 30),
            Map.entry("december", 31));

    private static final Map<String,Integer> MONTH_NAME_TO_NUMBER = Map.ofEntries(
            Map.entry("january", 1),
            Map.entry("february", 2),
            Map.entry("mars", 3),
            Map.entry("april", 4),
            Map.entry("may", 5),
            Map.entry("june", 6),
            Map.entry("july", 7),
            Map.entry("august", 8),
            Map.entry("september", 9),
            Map.entry("october", 10),
            Map.entry("november", 11),
            Map.entry("december", 12));
    private String name;


    public Month(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getMonthNumber(String name) {
        return MONTH_NAME_TO_NUMBER.getOrDefault(name, -1);
    }
    public static int getDaysInMonth(String name) {
        return MONTH_NAME_TO_LENGTH.getOrDefault(name, -1);
    }
}
