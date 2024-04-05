package org.codingdojo.yatzy2;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Yatzy2 implements YatzyCalculator {
    static final List<Integer> DICE_VALUES = Arrays.asList(6, 5, 4, 3, 2, 1);


    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(Enum::toString).collect(Collectors.toList());
    }

    @Override
    public int score(List<Integer> dice, String categoryName) {
        YatzyCategory category = YatzyCategory.valueOf(categoryName);
        int result;
        switch (category) {
            case CHANCE:
                result = dice.stream().mapToInt(Integer::intValue).sum();
                break;
            case YATZY:
                int yatzyResult = 0;
                if (frequencies(dice).containsValue(5)) {
                    yatzyResult = 50;
                }
                result = yatzyResult;
                break;
            case ONES:
                result = frequencies(dice).get(1);
                break;
            case TWOS:
                result = frequencies(dice).get(2) * 2;
                break;
            case THREES:
                result = frequencies(dice).get(3) * 3;
                break;
            case FOURS:
                result = frequencies(dice).get(4) * 4;
                break;
            case FIVES:
                result = frequencies(dice).get(5) * 5;
                break;
            case SIXES:
                result = frequencies(dice).get(6) * 6;
                break;
            case PAIR:
                int pairResult = 0;
                for (int i : DICE_VALUES) {
                    if (frequencies(dice).get(i) >= 2) {
                        pairResult = i * 2;
                        break;
                    }
                }
                result = pairResult;
                break;
            case THREE_OF_A_KIND:
                int threeKindResult = 0;
                for (int i : DICE_VALUES) {
                    if (frequencies(dice).get(i) >= 3) {
                        threeKindResult = i * 3;
                        break;
                    }
                }
                result = threeKindResult;
                break;
            case FOUR_OF_A_KIND:
                int fourKindResult = 0;
                for (int i : DICE_VALUES) {
                    if (frequencies(dice).get(i) >= 4) {
                        fourKindResult = i * 4;
                        break;
                    }
                }
                result = fourKindResult;
                break;
            case SMALL_STRAIGHT:
                int smallStraightResult = 0;
                long count = 0L;
                for (Integer frequency : frequencies(dice).values()) {
                    if (frequency == 1) {
                        count++;
                    }
                }
                if (count == 5 && frequencies(dice).get(6) == 0) {
                    for (Integer die : dice) {
                        smallStraightResult += die;
                    }
                }
                result = smallStraightResult;
                break;
            case LARGE_STRAIGHT:
                int largeStraightResult = 0;
                long straightCount = 0L;
                for (Integer frequency : frequencies(dice).values()) {
                    if (frequency == 1) {
                        straightCount++;
                    }
                }
                if (straightCount == 5 && frequencies(dice).get(1) == 0) {
                    for (Integer die : dice) {
                        largeStraightResult += die;
                    }
                }
                result = largeStraightResult;
                break;
            case TWO_PAIRS:
                int twoPairResult = 0;
                long pairCount = 0L;
                for (Integer frequency : frequencies(dice).values()) {
                    if (frequency >= 2) {
                        pairCount++;
                    }
                }
                if (pairCount == 2) {
                    for (int i : DICE_VALUES) {
                        if (frequencies(dice).get(i) >= 2) {
                            twoPairResult += i*2;
                        }
                    }
                }
                result = twoPairResult;
                break;
            case FULL_HOUSE:
                int fullHouseResult = 0;
                Map<Integer, Integer> frequencies = frequencies(dice);
                if (frequencies.containsValue(2) && frequencies.containsValue(3)) {
                    for (Integer die : dice) {
                        fullHouseResult += die;
                    }
                }
                result = fullHouseResult;
                break;
            default:
                result = 0;
        }
        return result;
    }

    Map<Integer, Integer> frequencies(List<Integer> dice) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int i : DICE_VALUES) {
            frequencies.put(i, 0);
        }
        for (int die : dice) {
            frequencies.put(die, frequencies.get(die) + 1);
        }

        return frequencies;
    }

}

