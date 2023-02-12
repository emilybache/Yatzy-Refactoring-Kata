package yatzy.category;

import yatzy.ScoreCategory;
import yatzy.Dice;
import yatzy.Score;

import java.util.List;

public class ChanceScore implements ScoreCategory {


    private final List<Dice> dices;

    public ChanceScore(List<Dice> dices) {
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");
        this.dices = dices;
    }

    @Override
    public Score score() {
        return Score.of(dices.stream()
            .map(Dice::getValue)
            .reduce(0, Integer::sum));
    }
}
