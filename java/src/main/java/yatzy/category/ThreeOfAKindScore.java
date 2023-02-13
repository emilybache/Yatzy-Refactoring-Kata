package yatzy.category;

import yatzy.Dice;
import yatzy.Score;
import yatzy.ScoreCategory;

import java.util.List;

public class ThreeOfAKindScore extends XOfAKindScore implements ScoreCategory {

    public ThreeOfAKindScore(List<Dice> dices) {
        super(dices);
    }

    @Override
    public Score score() {
        return this.score(NumberOfAKind.THREE);
    }
}
