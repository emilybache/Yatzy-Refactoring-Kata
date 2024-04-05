package org.codingdojo.yatzy3;

import java.util.List;

public class YatzyPointsScorer extends CategoryScorer  {
    @Override
    public int calculateScore(List<Integer> dice) {
        if (frequencies(dice).containsValue(5)) {
            return 50;
        }
        return 0;
    }
}
