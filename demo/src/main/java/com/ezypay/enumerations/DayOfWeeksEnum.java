package com.ezypay.enumerations;

import java.time.DayOfWeek;

public enum DayOfWeeksEnum {
    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY"),
    SUNDAY("SUNDAY");

    private String code;
  
    DayOfWeeksEnum(String code) {
        this.code = code;
        
    }

    public String getCode() {
        return code;
    }

    public static DayOfWeek getDayOfWeek(String dayOfWeek){
        if(MONDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.MONDAY;
        } else if (TUESDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.TUESDAY;
        } else if (WEDNESDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.WEDNESDAY;
        } else if (THURSDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.THURSDAY;
        } else if (FRIDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.FRIDAY;
        } else if (SATURDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.SATURDAY;
        } else if (SUNDAY.getCode().equals(dayOfWeek)){
            return DayOfWeek.SUNDAY;
        }
        return null;
    }
}
