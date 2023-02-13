import yatzy.Dice;
import yatzy.Score;
import yatzy.category.*;

import java.util.List;

public class Yatzy {


    private final List<Dice> dices;
    /**
     * @deprecated used the constructor with dices. This is just for backward compatibility
     */
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

    public Score chance()
    {
        return new ChanceScore(dices).score();
    }

    public Score yatzy()
    {
        return new YatzyScore(dices).score();
    }
    public Score ones()
    {
        return new OneValueScore(dices, Dice.of(1)).score();
    }

    public Score twos()
    {
        return new OneValueScore(dices, Dice.of(2)).score();
    }

    public Score threes()
    {
        return new OneValueScore(dices, Dice.of(3)).score();
    }

    public Score fours()
    {
        return new OneValueScore(dices, Dice.of(4)).score();
    }

    public Score fives()
    {
        return new OneValueScore(dices, Dice.of(5)).score();
    }

    public Score sixes()
    {
        return new OneValueScore(dices, Dice.of(6)).score();
    }

    public Score score_pair()
    {
        return new PairScore(dices).score();
    }

    public Score two_pair()
    {
        return new TwoPairsScore(dices).score();
    }

    public Score four_of_a_kind()
    {
        return new FourOfAKindScore(dices).score();
    }

    public Score three_of_a_kind()
    {
        return new ThreeOfAKindScore(dices).score();
    }

    public Score smallStraight()
    {
        return new SmallStraightScore(dices).score();
    }

    public Score largeStraight()
    {
        return new LargeStraightScore(dices).score();
    }

    public Score fullHouse()
    {
        return new FullHouseScore(dices).score();
    }
}



