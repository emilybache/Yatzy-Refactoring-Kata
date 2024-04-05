package yatzy2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Yatzy2 implements  YatzyCalculator {
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
            case chance:
                result = chance(dice);
                break;
            case yatzy:
                result = yatzy(dice);
                break;
            case ones:
                result = ones(dice);
                break;
            case twos:
                result = twos(dice);
                break;
            case threes:
                result = threes(dice);
                break;
            case fours:
                result = fours(dice);
                break;
            case fives:
                result = fives(dice);
                break;
            case sixes:
                result = sixes(dice);
                break;
            case pair:
                result = pair(dice);
                break;
            case threeofakind:
                result = threeofakind(dice);
                break;
            case fourofakind:
                result = fourofakind(dice);
                break;
            case smallstraight:
                result = smallstraight(dice);
                break;
            case largestraight:
                result = largestraight(dice);
                break;
            case twopairs:
                result = twopairs(dice);
                break;
            case fullhouse:
                result = fullhouse(dice);
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

    int numberFrequency(int number, List<Integer> dice) {
        return frequencies(dice).get(number)*number;
    }

    int nofakind(int n, List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        for (int i : Arrays.asList(6, 5, 4, 3, 2, 1)) {
            if (frequencies.get(i) >= n) {
                return i*n;
            }
        }
        return 0;
    }

    boolean isStraight(List<Integer> dice) {
        return frequencies(dice).values().stream().filter(f -> f == 1).collect(Collectors.toList()).size() == 5;
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
        if (frequencies(dice).values().stream().filter(f -> f >= 2).collect(Collectors.toList()).size() == 2) {
            for (int i : DICE_VALUES) {
                if (frequencies.get(i) >= 2) {
                    score += i*2;
                }
            }
        }
        return score;
    }

    public int fullhouse(List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        if (frequencies.values().contains(2) && frequencies.values().contains(3)) {
            return sum(dice);
        }
        return 0;
    }
}

