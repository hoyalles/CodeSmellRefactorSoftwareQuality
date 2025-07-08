package org.example.studyplanner;

import java.text.MessageFormat;
import java.util.Objects;

public class ToDo implements PlannerMaterial {
    private Integer id;
    private final String title;
    private final String description;
    private final int priority;

    public ToDo(Integer id, String title, String description, int priority) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        if (priority < 0 || priority > 5) {
            throw new IllegalArgumentException("A prioridade deve estar entre 0 e 5.");
        }

        this.id = id;
        this.title = title.trim();
        this.description = (description == null) ? "" : description.trim();
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID deve ser positivo.");
        }
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasHighPriority() {
        return this.priority >= 4;
    }

    public String summary() {
        return MessageFormat.format("ToDo {0}: {1} (Prioridade: {2})", id, title, priority);
    }

    @Override
    public String toString() {
        return MessageFormat.format("[(Priority:{3}) ToDo {0}: {1}, {2}]",
                id, title, description, priority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo)) return false;
        ToDo toDo = (ToDo) o;
        return Objects.equals(id, toDo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
