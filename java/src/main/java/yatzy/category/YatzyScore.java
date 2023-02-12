package yatzy.category;

import yatzy.Dice;
import yatzy.Score;
import yatzy.ScoreCategory;

import java.util.List;

public class YatzyScore implements ScoreCategory {

    private final List<Dice> dices;

    public YatzyScore(List<Dice> dices) {
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");
        this.dices = dices;
    }

    @Override
    public Score score() {
        if (ScoreHelper.countNumberOfDiceForEachValue(dices).size() == 1)
            return Score.of(50);
        return Score.of(0);
    }
}
