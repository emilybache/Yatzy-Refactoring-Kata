import yatzy.category.*;
import yatzy.Dice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {


    List<Dice> dices;
    public Yatzy(int d1, int d2, int d3, int d4, int _5)
    {
        int[] dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;

        dices = Arrays.stream(dice)
            .mapToObj(Dice::of)
            .collect(Collectors.toList());
    }

    public int chance()
    {
        return new ChanceScore(dices).score().getScore();
    }

    public int yatzy()
    {
        return new YatzyScore(dices).score().getScore();
    }
    public int ones()
    {
        return new OneValueScore(dices, Dice.of(1)).score().getScore();
    }

    public int twos()
    {
        return new OneValueScore(dices, Dice.of(2)).score().getScore();
    }

    public int threes()
    {
        return new OneValueScore(dices, Dice.of(3)).score().getScore();
    }

    public int fours()
    {
        return new OneValueScore(dices, Dice.of(4)).score().getScore();
    }

    public int fives()
    {
        return new OneValueScore(dices, Dice.of(5)).score().getScore();
    }

    public int sixes()
    {
        return new OneValueScore(dices, Dice.of(6)).score().getScore();
    }

    public int score_pair()
    {
        return new XOfAKindScore(dices, XOfAKindScore.NumberOfAKind.TWO).score().getScore();
    }

    public int two_pair()
    {
        return new TwoPairsScore(dices).score().getScore();
    }

    public int four_of_a_kind()
    {
        return new XOfAKindScore(dices, XOfAKindScore.NumberOfAKind.FOUR).score().getScore();
    }

    public int three_of_a_kind()
    {
        return new XOfAKindScore(dices, XOfAKindScore.NumberOfAKind.THREE).score().getScore();
    }

    public int smallStraight()
    {
        return new SmallStraightScore(dices).score().getScore();
    }

    public int largeStraight()
    {
        return new LargeStraightScore(dices).score().getScore();
    }

    public int fullHouse()
    {
        return new FullHouseScore(dices).score().getScore();
    }
}



