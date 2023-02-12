import yatzy.Dice;
import yatzy.category.*;

import java.util.List;

public class Yatzy {


    private final List<Dice> dices;
    @Deprecated
    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        this(Dice.of(d1),Dice.of(d2),Dice.of(d3),Dice.of(d4),Dice.of(d5));
    }

    public Yatzy(Dice d1, Dice d2, Dice d3, Dice d4, Dice d5){
        dices = List.of(d1, d2, d3, d4, d5);
    }

    public Yatzy(List<Dice> dices){
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");
        this.dices = dices;
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



