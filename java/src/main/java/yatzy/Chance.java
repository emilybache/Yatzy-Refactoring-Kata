package yatzy;

import java.util.List;

public class Chance implements Category{


    private final List<Dice> dices;

    public Chance(List<Dice> dices) {
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
