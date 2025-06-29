package org.example.studycards;

public class Card {
    private String question;
    private String answer;

    public Card(String question, String answer) {
        setQuestion(question);
        setAnswer(answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        if (question == null || question.isEmpty()) {
            throw new IllegalArgumentException("Question cannot be null or empty");
        }
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        if (answer == null || answer.isEmpty()) {
            throw new IllegalArgumentException("Answer cannot be null or empty");
        }
        this.answer = answer;
    }

    public void edit(String question, String answer) {
        setQuestion(question);
        setAnswer(answer);
    }

    // Método de comportamento que dá mais sentido à classe Card
    public boolean containsText(String text) {
        return (question != null && question.contains(text)) ||
                (answer != null && answer.contains(text));
    }

    // Opcional: método para formatar o próprio card como string (para substituir formatCard no manager)
    public String formatCard(Integer id) {
        return "[id: " + id + "] Question: " + question + " Answer: " + answer;
    }
}
