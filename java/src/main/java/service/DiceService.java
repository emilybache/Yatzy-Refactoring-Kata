package service;

import model.Dice;

import java.util.Collections;
import java.util.List;

public class DiceService {
    public static final List<Integer> SMALL_STRAIGHT = List.of(1,2,3,4,5);
    public static final List<Integer> LARGE_STRAIGHT = List.of(2,3,4,5,6);

    public boolean areAllTheSame(Dice dice) {
        return dice.areAllTheSame();
    }

    public int sum(Dice dice) {
        return dice.sum();
    }
    public boolean isSmallStraight(Dice dice) {
        return SMALL_STRAIGHT.equals(dice.getSortedCombination());
    }

    public boolean isLargeStraight(Dice dice) {
        return LARGE_STRAIGHT.equals(dice.getSortedCombination());
    }

    public int getSumOfXsInDice(int x, Dice dice) {
        return Math.toIntExact(dice.getCombination()
            .stream()
            .filter(number -> number == x)
            .count() * x);
    }

    public List<Integer> getListdistinctDieFoundMoreThenXTimes(Dice dice, int times) {
        return dice.getCombination()
            .stream()
            .sorted()
            .filter(i -> Collections.frequency(dice.getCombination(), i) >= times)
            .distinct().toList();
    }

    public List<Integer> getListdistinctDieFoundOnlyXTimes(Dice dice, int times) {
        return dice.getCombination()
            .stream()
            .sorted()
            .filter(i -> Collections.frequency(dice.getCombination(), i) == times)
            .distinct().toList();
    }
}
