package org.codingdojo.yatzy3;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TwoPairsScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        int score = 0;
        if (frequencies(dice).values().stream().filter(f -> f >= 2).toList().size() == 2) {
            score = Stream.of(6, 5, 4, 3, 2, 1)
                .mapToInt(i -> i)
                .filter(i -> frequencies.get(i) >= 2)
                .map(i -> i * 2)
                .sum();
        }
        return score;
    }
}
