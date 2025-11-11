package org.codingdojo.yatzy3;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy3 implements YatzyCalculator {
    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(Enum::toString).collect(Collectors.toList());
    }

    @Override
    public int score(List<Integer> dice, String category) {
        return CategoryScorer.createInstance(category).calculateScore(dice);
    }
}
