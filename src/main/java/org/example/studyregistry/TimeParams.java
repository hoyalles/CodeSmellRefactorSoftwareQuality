package org.example.studyregistry;

public class TimeParams {
    public Integer practicedDays;
    public int day;
    public int month;
    public int year;
    public Double duration;

    public TimeParams(Integer practicedDays, int day, int month, int year, Double duration) {
        this.practicedDays = practicedDays;
        this.day = day;
        this.month = month;
        this.year = year;
        this.duration = duration;
    }
}
