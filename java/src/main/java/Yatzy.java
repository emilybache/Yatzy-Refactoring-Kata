import model.Dice;
import service.DiceService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {
    private final DiceService diceService;

    public Yatzy(DiceService diceService) {
        this.diceService = diceService;
    }

    public int chance(Dice dice) {
        return diceService.sum(dice);
    }

    public int yatzy(Dice dice) {
        return diceService.areAllTheSame(dice) ? 50 : 0;
    }

    public int ones(Dice dice) {
        return diceService.getSumOfXsInDice(1, dice);
    }

    public int twos(Dice dice) {
        return diceService.getSumOfXsInDice( 2, dice);
    }

    public int threes(Dice dice) {
        return diceService.getSumOfXsInDice(3, dice);
    }

    public int fours(Dice dice) {
        return diceService.getSumOfXsInDice(4,  dice);
    }

    public int fives(Dice dice) {
        return diceService.getSumOfXsInDice(5,dice);
    }

    public int sixes(Dice dice) {
        return diceService.getSumOfXsInDice(6, dice);
    }

    public int onePair(Dice dice) {
        List<Integer> distinctDieFoundMoreThenTwoTimes = diceService.getListdistinctDieFoundMoreThenXTimes(dice, 2);
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
        List<Integer> distinctDieFoundMoreThenTwoTimes = diceService.getListdistinctDieFoundMoreThenXTimes(dice, 2);
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
        List<Integer> distinctDieFoundMoreThenFourtimes = diceService.getListdistinctDieFoundMoreThenXTimes(dice, 4);
        if (distinctDieFoundMoreThenFourtimes.size() != 0) {
            return distinctDieFoundMoreThenFourtimes.get(0) * 4;
        } else {
            return 0;
        }
    }

    public int threeOfAKind(Dice dice) {
        List<Integer> distinctDieFoundMoreThenThreetimes = diceService.getListdistinctDieFoundMoreThenXTimes(dice, 3);
        if (distinctDieFoundMoreThenThreetimes.size() != 0) {
            return distinctDieFoundMoreThenThreetimes.get(0) * 3;
        } else {
            return 0;
        }
    }

    public int smallStraight(Dice dice) {
        return diceService.isSmallStraight(dice) ? 15 : 0;
    }

    public int largeStraight(Dice dice) {
        return diceService.isLargeStraight(dice) ? 20 : 0;
    }

    public int fullHouse(Dice dice) {
        List<Integer> distinctDieFoundOnlyTwoTimes = diceService.getListdistinctDieFoundOnlyXTimes(dice, 2);

        List<Integer> distinctDieFoundOnlyThreeTimes =  diceService.getListdistinctDieFoundOnlyXTimes(dice, 3);

        if (distinctDieFoundOnlyTwoTimes.size() != 0 && distinctDieFoundOnlyThreeTimes.size() != 0) {
            return distinctDieFoundOnlyTwoTimes.get(0)*2 + distinctDieFoundOnlyThreeTimes.get(0)*3;
        } else {
            return 0;
        }
    }
}



