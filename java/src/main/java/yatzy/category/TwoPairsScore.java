package yatzy.category;

import yatzy.Dice;
import yatzy.Score;
import yatzy.ScoreCategory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoPairsScore implements ScoreCategory {
    private final List<Dice> dices;

    public TwoPairsScore(List<Dice> dices) {
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");
        this.dices = dices;
    }
    @Override
    public Score score() {
        Map<Dice, Long> frequencies = ScoreHelper.getFrequencyOfEachDiceValue(dices);

        List<Dice> pairsOfDiceList = frequencies.entrySet()
            .stream()
            .filter(e -> e.getValue() >= 2)
            .map(e -> e.getKey())
            .collect(Collectors.toList());

        if (pairsOfDiceList.size() == 2){
                return Score.of(pairsOfDiceList
                    .stream()
                    .mapToInt(d -> d.getValue() * 2)
                    .reduce(0, Integer::sum));
        }
        return Score.of(0);
    }
}
