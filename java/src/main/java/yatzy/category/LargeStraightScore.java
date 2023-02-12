package yatzy.category;

import yatzy.Dice;
import yatzy.Score;
import yatzy.ScoreCategory;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LargeStraightScore implements ScoreCategory {
    private final List<Dice> dices;

    public LargeStraightScore(List<Dice> dices) {
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
            if(Dice.of(2).equals(minDice)
                && Dice.of(6).equals(maxDice))
                return Score.of(20);
        }
        return Score.of(0);
    }
}
