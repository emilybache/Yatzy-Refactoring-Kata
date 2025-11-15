package org.codingdojo.yatzy3;

import java.util.List;

public class NumberScorer extends CategoryScorer  {
    private final int number;

    public NumberScorer(int number) {
        this.number = number;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        return frequencies(dice).get(number) * number;
    }
}
