import model.Dice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {
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

    public int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



