package org.example.studyplanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TodoReportFormatter {

    public static String formatTodoTracker(TodoTracker tracker) {
        List<ToDo> toDos = tracker.getToDos();
        if (toDos.isEmpty()) return "No ToDos found";

        StringBuilder str = new StringBuilder();
        for (ToDo toDo : toDos) {
            str.append(formatToDoWithTracks(tracker, toDo));
        }
        return str.toString();
    }

    private static String formatToDoWithTracks(TodoTracker tracker, ToDo toDo) {
        StringBuilder result = new StringBuilder();
        result.append(toDo.toString()).append("\n");

        List<LocalDateTime> dates = tracker.getExecutionDates(toDo.getId());
        if (dates == null || dates.isEmpty()) {
            result.append("No tracks found\n");
        } else {
            result.append(formatExecutionDates(dates));
        }
        return result.toString();
    }

    private static String formatExecutionDates(List<LocalDateTime> dates) {
        StringBuilder sb = new StringBuilder();
        for (LocalDateTime date : dates) {
            sb.append(formatDate(date)).append("\n");
        }
        return sb.toString();
    }

    private static String formatDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
