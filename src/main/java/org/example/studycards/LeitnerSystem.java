package org.example.studycards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeitnerSystem extends StudyMethod {
    private List<Box> boxes;

    public LeitnerSystem(String methodName) {
        super(methodName);
        this.boxes = new ArrayList<>(Arrays.asList(new Box(), new Box(), new Box(), new Box(), new Box()));
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }

    @Override
    void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        int index = 0;
        for (Box box : boxes) {
            response.append("Box ").append(index).append(": ").append(box.toString()).append("\n");
            index++;
        }
        return response.toString();
    }

    public void clearBoxes() {
        boxes.clear();
        boxes = new ArrayList<>(Arrays.asList(new Box(), new Box(), new Box(), new Box(), new Box()));
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public String getRandomCard(List<Box> otherBoxes) {
        if (isBoxListInvalid(otherBoxes)) return null;

        Box allBoxes = mergeBoxes(otherBoxes);
        Integer randomCardId = allBoxes.getRandomCard();

        if (randomCardId == null) {
            return "No card found";
        }

        return buildCardResponse(randomCardId);
    }

    private boolean isBoxListInvalid(List<Box> boxes) {
        return boxes == null || boxes.isEmpty();
    }

    private Box mergeBoxes(List<Box> boxesToMerge) {
        Box all = new Box();
        for (Box box : boxesToMerge) {
            all.addCards(box.getCards());
        }
        return all;
    }

    private String buildCardResponse(Integer cardId) {
        Card card = CardManager.getCardManager().getCard(cardId);
        return "[" + cardId + "] The random question was: " + card.getQuestion() + " | The answer is: " + card.getAnswer();
    }

    public void addCardToBox(Integer id, Integer boxId) {
        boxes.get(boxId).addCard(id);
    }

    public void removeCardFromBox(Integer id, Integer boxId) {
        boxes.get(boxId).removeCard(id);
    }

    public Card takeCardFromBox(Integer boxId) {
        Integer cardId = boxes.get(boxId).getRandomCard();
        return this.cardManager.getCard(cardId);
    }

    public void boxIdValidation(Integer boxId) throws Exception {
        if (boxId == null || boxId > (boxes.size() - 1) || boxId < 0) {
            throw new Exception("Invalid box ID");
        }
    }

    public void upgradeCard(Integer cardId, Integer boxId) throws Exception {
        moveCard(cardId, boxId, Math.min(boxId + 1, 4));
    }

    public void downgradeCard(Integer cardId, Integer boxId) throws Exception {
        moveCard(cardId, boxId, Math.max(boxId - 1, 0));
    }

    private void moveCard(Integer cardId, Integer fromBoxId, Integer toBoxId) throws Exception {
        boxIdValidation(fromBoxId);
        Box fromBox = boxes.get(fromBoxId);

        if (fromBox.hasCard(cardId)) {
            throw new Exception("No card Found");
        }

        fromBox.removeCard(cardId);
        boxes.get(toBoxId).addCard(cardId);
    }
}
