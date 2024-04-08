package yatzy;

import java.util.List;

public class Yatzy {

    public int chance(Dice d) {
        return d.sum();
    }

    public int yatzy(Dice d) {
        return d.areAllTheSame() ? 50 : 0;
    }

    public int ones(Dice d) {
        return d.getSumOfNumbersXInDiceWhenPlacedOnCategoryX(1);
    }

    public int twos(Dice d) {
        return d.getSumOfNumbersXInDiceWhenPlacedOnCategoryX(2);
    }

    public int threes(Dice d) {
        return d.getSumOfNumbersXInDiceWhenPlacedOnCategoryX(3);
    }

    public int fours(Dice d) {
        return d.getSumOfNumbersXInDiceWhenPlacedOnCategoryX(4);
    }

    public int fives(Dice d) {
        return d.getSumOfNumbersXInDiceWhenPlacedOnCategoryX(5);
    }

    public int sixs(Dice d) {
        return d.getSumOfNumbersXInDiceWhenPlacedOnCategoryX(6);
    }

    public int pair(Dice d) {
        List<Integer> listDistinctNumbers = d.getListofDistinctNumberFoundMoreThanXTimesInDice(2);
        if (listDistinctNumbers.isEmpty()) return 0;
        return listDistinctNumbers.stream().skip(Math.max(0, listDistinctNumbers.size() - 1)).mapToInt(Integer::valueOf).sum() * 2;
    }

    public int twoPairs(Dice d) {
        List<Integer> listDistinctNumbers = d.getListofDistinctNumberFoundMoreThanXTimesInDice(2);
        if (listDistinctNumbers.isEmpty()) return 0;
        return listDistinctNumbers.stream().skip(Math.max(0, listDistinctNumbers.size() - 2)).mapToInt(Integer::valueOf).sum() * 2;

    }

    public int threeOfKind(Dice d) {
        List<Integer> listDistinctNumbers = d.getListofDistinctNumberFoundMoreThanXTimesInDice(3);
        if (listDistinctNumbers.isEmpty()) return 0;
        return listDistinctNumbers.get(0) * 3;

    }

    public int fourOfKind(Dice d) {
        List<Integer> listDistinctNumbers = d.getListofDistinctNumberFoundMoreThanXTimesInDice(4);
        if (listDistinctNumbers.isEmpty()) return 0;
        return listDistinctNumbers.get(0) * 4;
    }

    public int smallStraight(Dice d) {
        return d.areSmallStraight() ? 15 : 0;
    }

    public int largeStraight(Dice d) {
        return d.areAllLargeStraight() ? 20 : 0;
    }

    public int fullHouse(Dice d) {
    }


}
