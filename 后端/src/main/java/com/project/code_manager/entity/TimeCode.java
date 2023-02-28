<<<<<<< HEAD
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class TimeCode{
    String rawData;
    String year;
    String monthAndDay;
    String hour;
    String minute;
    String second;
    public void handle(){
        setYear(rawData.substring(0,4));
        setMonthAndDay(rawData.substring(4,8));
        setHour(rawData.substring(8,10));
        setMinute(rawData.substring(10,12));
        setSecond(rawData.substring(12,14));
    }
    @Override
    public String toString(){
        return year + monthAndDay + "-" + hour + minute + second;
    }
}
=======
package com.project.code_manager.entity;

import lombok.Data;

@Data
public class TimeCode{
    String rawData;
    String year;
    String monthAndDay;
    String hour;
    String minute;
    String second;
    public void handle(){
        setYear(rawData.substring(0,4));
        setMonthAndDay(rawData.substring(4,8));
        setHour(rawData.substring(8,10));
        setMinute(rawData.substring(10,12));
        setSecond(rawData.substring(12,14));
    }
    @Override
    public String toString(){
        return year + monthAndDay + "-" + hour + minute + second;
    }
}
>>>>>>> ac191af (update)
