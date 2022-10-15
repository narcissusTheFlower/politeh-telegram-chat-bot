package org.lev.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class DaysTillSessionCounter {

    private static final Temporal today = LocalDate.now();
    //TODO remember to change dates
    private static final Temporal sessionStartDay = LocalDate.of(2023,1,19);

    public static String DaysTillSessionWithProperCase(){
        if (getDaysTillSession().endsWith(String.valueOf(1))) {
            return "остался " + getDaysTillSession() + " день";
        }else return "осталось " + getDaysTillSession() + " дней";
    }

    private static String getDaysTillSession(){
        return String.valueOf(ChronoUnit.DAYS.between(today, sessionStartDay));
    }
}
