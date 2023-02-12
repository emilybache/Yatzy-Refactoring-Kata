package yatzy.category;

import yatzy.Dice;
import yatzy.Score;
import yatzy.ScoreCategory;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FullHouseScore implements ScoreCategory {
    private final List<Dice> dices;

    public FullHouseScore(List<Dice> dices) {
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");
        this.dices = dices;
    }
    @Override
    public Score score() {
        Map<Dice, Long> frequencies = ScoreHelper.getFrequencyOfEachDiceValue(dices);
        if (frequencies.size() == 2){
            int minFrequency = Collections.min(frequencies.values()).intValue();
            int maxFrequency = Collections.max(frequencies.values()).intValue();
            if(minFrequency == 2 && maxFrequency == 3){
                return Score.of(frequencies.entrySet()
                    .stream()
                    .mapToInt(e -> e.getKey().getValue() * e.getValue().intValue())
                    .reduce(0, Integer::sum));
            }
        }
        return Score.of(0);
    }
}
