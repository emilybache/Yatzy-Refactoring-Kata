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
                result = nofakind(2, dice);
                break;
            case THREE_OF_A_KIND:
                result = nofakind(3, dice);
                break;
            case FOUR_OF_A_KIND:
                result = nofakind(4, dice);
                break;
            case SMALL_STRAIGHT:
                int smallStraightResult = 0;
                if (frequencies(dice).values().stream().filter(f2 -> f2 == 1).count() == 5 && frequencies(dice).get(6) == 0) {
                    smallStraightResult = dice.stream().mapToInt(Integer::intValue).sum();
                }
                result = smallStraightResult;
                break;
            case LARGE_STRAIGHT:
                int largeStraightResult = 0;
                if (frequencies(dice).values().stream().filter(f1 -> f1 == 1).count() == 5 && frequencies(dice).get(1) == 0) {
                    largeStraightResult = dice.stream().mapToInt(Integer::intValue).sum();
                }
                result = largeStraightResult;
                break;
            case TWO_PAIRS:
                int score = 0;
                if (frequencies(dice).values().stream().filter(f -> f >= 2).count() == 2) {
                    for (int i : DICE_VALUES) {
                        if (frequencies(dice).get(i) >= 2) {
                            score += i*2;
                        }
                    }
                }
                result = score;
                break;
            case FULL_HOUSE:
                int fullHouseResult = 0;
                Map<Integer, Integer> frequencies = frequencies(dice);
                if (frequencies.containsValue(2) && frequencies.containsValue(3)) {
                    fullHouseResult = dice.stream().mapToInt(Integer::intValue).sum();
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

    int nofakind(int n, List<Integer> dice) {
        for (int i : Arrays.asList(6, 5, 4, 3, 2, 1)) {
            if (frequencies(dice).get(i) >= n) {
                return i*n;
            }
        }
        return 0;
    }

}

