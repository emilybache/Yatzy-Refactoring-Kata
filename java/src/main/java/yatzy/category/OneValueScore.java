package yatzy.category;

import yatzy.Dice;
import yatzy.Score;
import yatzy.ScoreCategory;

import java.util.List;

public class OneValueScore implements ScoreCategory {

    private final List<Dice> dices;
    private final Dice readDice;
    public OneValueScore(List<Dice> dices, Dice readDice) {
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");

        if(readDice == null)
            throw new IllegalArgumentException("readDice is mandatory !");

        this.dices = dices;
        this.readDice = readDice;
    }

    @Override
    public Score score() {

        return Score.of(dices.stream()
            .filter(d -> d.equals(readDice))
            .map(Dice::getValue)
            .reduce(0, Integer::sum));
    }
}
