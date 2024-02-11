package model;

import java.util.Arrays;
import java.util.List;

public record Dice(int die0, int die1, int die2, int die3, int die4) {
    public List<Integer> getCombination() {
        return Arrays.asList(die0, die1, die2, die3, die4);
    }

    public boolean areAllTheSame() {
        return this.getCombination()
            .stream()
            .allMatch(getCombination().get(0)::equals);
    }

    public List<Integer> getSortedCombination() {
        return this.getCombination()
            .stream()
            .sorted()
            .toList();
    }

    public int sum() {
        return this.getCombination()
            .stream()
            .reduce(0, Integer::sum);
    }
}
