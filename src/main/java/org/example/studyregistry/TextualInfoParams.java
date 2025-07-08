package org.example.studyregistry;

public class TextualInfoParams {
    public String title;
    public String description;
    public String topic;
    public String objectiveInOneLine;
    public String objectiveFullDescription;
    public String motivation;

    public TextualInfoParams(String title, String description, String topic, String objectiveInOneLine, String objectiveFullDescription, String motivation) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.objectiveInOneLine = objectiveInOneLine;
        this.objectiveFullDescription = objectiveFullDescription;
        this.motivation = motivation;
    }
}

