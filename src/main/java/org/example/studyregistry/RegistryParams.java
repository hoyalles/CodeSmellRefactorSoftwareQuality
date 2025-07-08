package org.example.studyregistry;

public class RegistryParams {
    public Integer id;
    public String name;
    public Integer priority;
    public boolean isActive;

    public RegistryParams(Integer id, String name, Integer priority, boolean isActive) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.isActive = isActive;
    }
}
