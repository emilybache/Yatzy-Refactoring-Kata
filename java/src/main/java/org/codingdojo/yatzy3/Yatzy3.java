package org.codingdojo.yatzy3;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy3 implements YatzyCalculator {
    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(Enum::toString).collect(Collectors.toList());
    }

    @Override
    public int score(List<Integer> dice, String category) {
        switch (category) {
            case "CHANCE":
                return chance(dice);
            case "YATZY":
                return yatzy(dice);
            case "ONES":
                return ones(dice);
            case "TWOS":
                return twos(dice);
            case "THREES":
                return threes(dice);
            case "FOURS":
                return fours(dice);
            case "FIVES":
                return fives(dice);
            case "SIXES":
                return sixes(dice);
            case "PAIR":
                return pair(dice);
            case "TWO_PAIRS":
                return twopairs(dice);
            case "THREE_OF_A_KIND":
                return threeofakind(dice);
            case "FOUR_OF_A_KIND":
                return fourofakind(dice);
            case "SMALL_STRAIGHT":
                return smallstraight(dice);
            case "LARGE_STRAIGHT":
                return largestraight(dice);
            case "FULL_HOUSE":
                return fullhose(dice);
        }
        return -1;
    }
    Map<Integer, Integer> frequencies(List<Integer> dice) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int i : Arrays.asList(6, 5, 4, 3, 2, 1)) {
            frequencies.put(i, 0);
        }
        for (int die : dice) {
            frequencies.put(die, frequencies.get(die) + 1);
        }

        return frequencies;
    }

    int numberFrequency(int number, List<Integer> dice) {
        return frequencies(dice).get(number)*number;
    }

    int nofakind(int n, List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        for (int i : Arrays.asList(6, 5,4,3,2,1)) {
            if (frequencies.get(i) >= n) {
                return i*n;
            }
        }
        return 0;
    }

    boolean isStraight(List<Integer> dice) {
        return frequencies(dice).values().stream().filter(f -> f == 1).toList().size() == 5;
    }

    int sum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    public int chance(List<Integer> dice) {
        return sum(dice);
    }

    public int yatzy(List<Integer> dice) {
        if (frequencies(dice).containsValue(5)) {
            return 50;
        }
        return 0;
    }

    public int ones(List<Integer> dice) {
        return numberFrequency(1, dice);
    }
    public int twos(List<Integer> dice) {
        return numberFrequency(2, dice);
    }
    public int threes(List<Integer> dice) {
        return numberFrequency(3, dice);
    }
    public int fours(List<Integer> dice) {
        return numberFrequency(4, dice);
    }
    public int fives(List<Integer> dice) {
        return numberFrequency(5, dice);
    }
    public int sixes(List<Integer> dice) {
        return numberFrequency(6, dice);
    }

    public int pair(List<Integer> dice) {
        return nofakind(2, dice);
    }

    public int threeofakind(List<Integer> dice) {
        return nofakind(3, dice);
    }

    public int fourofakind(List<Integer> dice) {
        return nofakind(4, dice);
    }

    public int smallstraight(List<Integer> dice) {
        if (isStraight(dice) && frequencies(dice).get(6) == 0) {
            return sum(dice);
        }
        return 0;
    }

    public int largestraight(List<Integer> dice) {
        if (isStraight(dice) && frequencies(dice).get(1) == 0) {
            return sum(dice);
        }
        return 0;
    }

    public int twopairs(List<Integer> dice) {
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

    public int fullhose(List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        if (frequencies.containsValue(2) && frequencies.containsValue(3)) {
            return sum(dice);
        }
        return 0;
    }
}
