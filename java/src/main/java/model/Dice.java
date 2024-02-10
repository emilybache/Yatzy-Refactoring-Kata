package model;

import java.util.Arrays;
import java.util.List;

public record Dice(int die0, int die1, int die2, int die3, int die4) {
    public List<Integer> getCombination() {
        return Arrays.asList(die0, die1, die2, die3, die4);
    }
}
