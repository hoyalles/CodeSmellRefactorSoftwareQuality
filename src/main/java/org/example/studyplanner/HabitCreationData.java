package org.example.studyplanner;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class HabitCreationData {
    private String name;
    private String motivation;
    private LocalTime dailyDedication;
    private LocalDateTime startDate;
    private Boolean isConcluded;

    public HabitCreationData(String name, String motivation, LocalTime dailyDedication, LocalDateTime startDate, Boolean isConcluded) {
        this.name = name;
        this.motivation = motivation;
        this.dailyDedication = dailyDedication;
        this.startDate = startDate;
        this.isConcluded = isConcluded;
    }

    public String getName() {
        return name;
    }

    public String getMotivation() {
        return motivation;
    }

    public LocalTime getDailyDedication() {
        return dailyDedication;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Boolean getIsConcluded() {
        return isConcluded;
    }
}
