package org.example.studysearch;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SearchLog {
    private LinkedList<String> searchHistory;
    private Map<String, Integer> searchCount;
    private boolean isLocked;
    private Integer numUsages;
    private String logName;

    public SearchLog(String logName) {
        searchHistory = new LinkedList<>();
        searchCount = new HashMap<>();
        this.logName = logName;
        numUsages = 0;
        isLocked = false;
    }

    public void addSearchHistory(String searchText) {
        logSearch(searchText);
    }

    public void logSearch(String searchText) {
        this.searchHistory.add(searchText);
        this.numUsages++;
    }

    // Retorna uma cópia para impedir alteração externa direta
    public LinkedList<String> getSearchHistory() {
        return new LinkedList<>(searchHistory);
    }

    public Map<String, Integer> getSearchCount() {
        return Collections.unmodifiableMap(searchCount);
    }

    public boolean isLocked() {
        return isLocked;
    }

    // Só permitir alterar locked se realmente necessário (pode deixar setter privado ou package-private)
    void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Integer getNumUsages() {
        return numUsages;
    }

    public String getLogName() {
        return logName;
    }

    // Remover setters públicos para evitar modificação indevida
    // Se precisar alterar, criar métodos específicos para isso, não setters genéricos
}
