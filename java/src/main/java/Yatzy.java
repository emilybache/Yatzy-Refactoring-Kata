import model.Dice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {
    public static final List<Integer> SMALL_STRAIGHT = List.of(1,2,3,4,5);
    public static final List<Integer> LARGE_STRAIGHT = List.of(2,3,4,5,6);

    public int chance(Dice dice) {
        return dice.getCombination()
            .stream()
            .reduce(0, Integer::sum);
    }

    public int yatzy(Dice dice) {
        if(dice.areAllTheSame()) {
            return 50;
        } else {
            return 0;
        }
    }

    public int ones(Dice dice) {
        return Math.toIntExact(dice.getCombination()
            .stream()
            .filter(number -> number == 1)
            .count());
    }

    public int twos(Dice dice) {
        return Math.toIntExact(dice.getCombination()
            .stream()
            .filter(number -> number == 2)
            .count() * 2);
    }

    public int threes(Dice dice) {
        return Math.toIntExact(dice.getCombination()
            .stream()
            .filter(number -> number == 3)
            .count() * 3);
    }

    public int fours(Dice dice) {
        return Math.toIntExact(dice.getCombination()
            .stream()
            .filter(number -> number == 4)
            .count() * 4);
    }

    public int fives(Dice dice) {
        return Math.toIntExact(dice.getCombination()
            .stream()
            .filter(number -> number == 5)
            .count() * 5);
    }

    public int sixes(Dice dice) {
        return Math.toIntExact(dice.getCombination()
            .stream()
            .filter(number -> number == 6)
            .count() * 6);
    }

    public int onePair(Dice dice) {
        List<Integer> distinctDieFoundMoreThenTwoTimes = dice.getCombination()
            .stream()
            .sorted()
            .filter(i -> Collections.frequency(dice.getCombination(), i) >= 2)
            .distinct().toList();
        if (distinctDieFoundMoreThenTwoTimes.size() >= 1) {
            return distinctDieFoundMoreThenTwoTimes.stream()
                .skip(Math.max(0, distinctDieFoundMoreThenTwoTimes.size() - 1))
                .mapToInt(Integer::valueOf)
                .sum() * 2;
        } else {
            return 0;
        }
    }

    public int twoPairs(Dice dice) {
        List<Integer> distinctDieFoundMoreThenTwoTimes = dice.getCombination()
            .stream()
            .sorted()
            .filter(i -> Collections.frequency(dice.getCombination(), i) >= 2)
            .distinct().toList();
        if (distinctDieFoundMoreThenTwoTimes.size() >= 2) {
            return distinctDieFoundMoreThenTwoTimes.stream()
                .skip(Math.max(0, distinctDieFoundMoreThenTwoTimes.size() - 2))
                .mapToInt(Integer::valueOf)
                .sum() * 2;
        } else {
            return 0;
        }
    }

    public int fourOfAKind(Dice dice) {
        List<Integer> distinctDieFoundMoreThenFourtimes = dice.getCombination()
            .stream()
            .sorted()
            .filter(i -> Collections.frequency(dice.getCombination(), i) >= 4)
            .distinct().toList();;
        if (distinctDieFoundMoreThenFourtimes.size() != 0) {
            return distinctDieFoundMoreThenFourtimes.get(0) * 4;
        } else {
            return 0;
        }
    }

    public int threeOfAKind(Dice dice) {
        List<Integer> distinctDieFoundMoreThenThreetimes = dice.getCombination()
            .stream()
            .sorted()
            .filter(i -> Collections.frequency(dice.getCombination(), i) >= 3)
            .distinct().toList();;
        if (distinctDieFoundMoreThenThreetimes.size() != 0) {
            return distinctDieFoundMoreThenThreetimes.get(0) * 3;
        } else {
            return 0;
        }
    }

    public int smallStraight(Dice dice) {
        if(SMALL_STRAIGHT.equals(dice.getCombination().stream().sorted().collect(Collectors.toList()))) {
            return 15;
        } else {
            return 0;
        }
    }

    public int largeStraight(Dice dice) {
        if(LARGE_STRAIGHT.equals(dice.getCombination().stream().sorted().collect(Collectors.toList()))) {
            return 20;
        } else {
            return 0;
        }
    }

    public int fullHouse(Dice dice) {
        List<Integer> distinctDieFoundMoreThenTwoTimes = dice.getCombination()
            .stream()
            .sorted()
            .filter(i -> Collections.frequency(dice.getCombination(), i) == 2)
            .toList();
        List<Integer> distinctDieFoundMoreThenThreeTimes = dice.getCombination()
            .stream()
            .sorted()
            .filter(i -> Collections.frequency(dice.getCombination(), i) == 3)
            .toList();
        if (distinctDieFoundMoreThenTwoTimes.size() != 0 && distinctDieFoundMoreThenThreeTimes.size() != 0) {
            return distinctDieFoundMoreThenTwoTimes.get(0)*2 + distinctDieFoundMoreThenThreeTimes.get(0)*3;
        } else {
            return 0;
        }
    }
}



