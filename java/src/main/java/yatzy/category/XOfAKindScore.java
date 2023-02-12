package yatzy.category;

import yatzy.Dice;
import yatzy.Score;
import yatzy.ScoreCategory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class XOfAKindScore implements ScoreCategory {

    private final List<Dice> dices;
    private final NumberOfAKind numberOfAKind;

    public enum NumberOfAKind{
        TWO(2L),
        THREE(3L),
        FOUR(4L);
        public final Long value;
        NumberOfAKind(Long value) {
            this.value = value;
        }
    }

    public XOfAKindScore(List<Dice> dices, NumberOfAKind numberOfAKind) {
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");

        if(numberOfAKind == null)
            throw new IllegalArgumentException("numberOfAKind is mandatory !");

        this.dices = dices;
        this.numberOfAKind = numberOfAKind;
    }

    @Override
    public Score score() {
        Map<Dice, Long> frequencies = ScoreHelper.getFrequencyOfEachDiceValue(dices);

        Optional<Map.Entry<Dice, Long>> optional = frequencies.entrySet()
            .stream()
            .filter(e -> e.getValue() >= numberOfAKind.value)
            .max(Map.Entry.comparingByKey());

        if(optional.isPresent()){
            return Score.of(optional.get().getKey().getValue() * numberOfAKind.value.intValue());
        }
        return Score.of(0);
    }
}
