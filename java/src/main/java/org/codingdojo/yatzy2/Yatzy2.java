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

        // calculate dice frequencies
        HashMap<Integer, Integer> diceFrequencies = new HashMap<>();
        for (int i : DICE_VALUES) {
            diceFrequencies.put(i, 0);
        }
        for (int die : dice) {
            diceFrequencies.put(die, diceFrequencies.get(die) + 1);
        }

        // calculate the score
        int result;
        switch (category) {
            case CHANCE:

                // chance sums the dice
                result = dice.stream().mapToInt(Integer::intValue).sum();
                break;

            case YATZY:

                // score for yatzy if all dice are the same
                int yatzyResult = 0;
                if (diceFrequencies.containsValue(5)) {
                    yatzyResult = 50;
                }
                result = yatzyResult;
                break;

            case ONES:
                // sum all the ones
                result = diceFrequencies.get(1);
                break;

            case TWOS:
                // sum all the twos
                result = diceFrequencies.get(2) * 2;
                break;

            case THREES:
                // sum all the threes
                result = diceFrequencies.get(3) * 3;
                break;

            case FOURS:
                // sum all the fours
                result = diceFrequencies.get(4) * 4;
                break;

            case FIVES:
                // sum all the fives
                result = diceFrequencies.get(5) * 5;
                break;

            case SIXES:
                // sum all the sixes
                result = diceFrequencies.get(6) * 6;
                break;

            case PAIR:

                // score pair if two dice are the same
                int pairResult = 0;
                // score highest pair if there is more than one
                for (int i : DICE_VALUES) {
                    if (diceFrequencies.get(i) >= 2) {
                        pairResult = i * 2;
                        break;
                    }
                }
                result = pairResult;
                break;

            case THREE_OF_A_KIND:

                // score if three dice are the same
                int threeKindResult = 0;
                for (int i : DICE_VALUES) {
                    if (diceFrequencies.get(i) >= 3) {
                        threeKindResult = i * 3;
                        break;
                    }
                }
                result = threeKindResult;
                break;

            case FOUR_OF_A_KIND:

                // score if four dice are the same
                int fourKindResult = 0;
                for (int i : DICE_VALUES) {
                    if (diceFrequencies.get(i) >= 4) {
                        fourKindResult = i * 4;
                        break;
                    }
                }
                result = fourKindResult;
                break;

            case SMALL_STRAIGHT:

                // score if dice contains 1,2,3,4,5
                int smallStraightResult = 0;
                long count = 0L;
                for (Integer frequency : diceFrequencies.values()) {
                    if (frequency == 1) {
                        count++;
                    }
                }
                if (count == 5 && diceFrequencies.get(6) == 0) {
                    for (Integer die : dice) {
                        smallStraightResult += die;
                    }
                }
                result = smallStraightResult;
                break;

            case LARGE_STRAIGHT:

                // score if dice contains 2,3,4,5,6
                int largeStraightResult = 0;
                long straightCount = 0L;
                for (Integer frequency : diceFrequencies.values()) {
                    if (frequency == 1) {
                        straightCount++;
                    }
                }
                if (straightCount == 5 && diceFrequencies.get(1) == 0) {
                    for (Integer die : dice) {
                        largeStraightResult += die;
                    }
                }
                result = largeStraightResult;
                break;

            case TWO_PAIRS:

                // score if there are two pairs
                int twoPairResult = 0;
                long pairCount = 0L;
                for (Integer frequency : diceFrequencies.values()) {
                    if (frequency >= 2) {
                        pairCount++;
                    }
                }
                if (pairCount == 2) {
                    for (int i : DICE_VALUES) {
                        if (diceFrequencies.get(i) >= 2) {
                            twoPairResult += i * 2;
                        }
                    }
                }
                result = twoPairResult;
                break;

            case FULL_HOUSE:

                // score if there is a pair as well as three of a kind
                int fullHouseResult = 0;
                if (diceFrequencies.containsValue(2) && diceFrequencies.containsValue(3)) {
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

}

