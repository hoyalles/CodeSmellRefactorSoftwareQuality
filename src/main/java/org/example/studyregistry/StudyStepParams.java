package org.example.studyregistry;

import java.time.LocalDateTime;
import java.util.List;

public class StudyStepParams {
    public String firstStep;
    public String resetStudyMechanism;
    public String consistentStep;
    public String seasonalSteps;
    public String basicSteps;
    public String mainObjectiveTitle;
    public String mainGoalTitle;
    public String mainMaterialTopic;
    public String mainTask;
    public Integer numberOfSteps;
    public boolean isImportant;
    public LocalDateTime startDate;
    public LocalDateTime endDate;

    public StudyStepParams(String firstStep, String resetStudyMechanism, String consistentStep, String seasonalSteps,
                           String basicSteps, String mainObjectiveTitle, String mainGoalTitle, String mainMaterialTopic,
                           String mainTask, Integer numberOfSteps, boolean isImportant, LocalDateTime startDate, LocalDateTime endDate) {
        this.firstStep = firstStep;
        this.resetStudyMechanism = resetStudyMechanism;
        this.consistentStep = consistentStep;
        this.seasonalSteps = seasonalSteps;
        this.basicSteps = basicSteps;
        this.mainObjectiveTitle = mainObjectiveTitle;
        this.mainGoalTitle = mainGoalTitle;
        this.mainMaterialTopic = mainMaterialTopic;
        this.mainTask = mainTask;
        this.numberOfSteps = numberOfSteps;
        this.isImportant = isImportant;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
