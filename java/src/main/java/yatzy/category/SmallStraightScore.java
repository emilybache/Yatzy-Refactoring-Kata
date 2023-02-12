package yatzy.category;

import yatzy.Dice;
import yatzy.Score;
import yatzy.ScoreCategory;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SmallStraightScore implements ScoreCategory {
    private final List<Dice> dices;

    public SmallStraightScore(List<Dice> dices) {
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");
        this.dices = dices;
    }
    @Override
    public Score score() {
        Set<Dice> singleDices = ScoreHelper.getFrequencyOfEachDiceValue(dices).keySet();
        if (singleDices.size() == 5){
            Dice minDice = Collections.min(singleDices);
            Dice maxDice = Collections.max(singleDices);
            if(Dice.of(1).equals(minDice)
                && Dice.of(5).equals(maxDice))
                return Score.of(15);
        }
        return Score.of(0);
    }
}
