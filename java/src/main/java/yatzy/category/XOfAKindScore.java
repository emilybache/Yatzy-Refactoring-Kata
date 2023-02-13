package yatzy.category;

import yatzy.Dice;
import yatzy.Score;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class XOfAKindScore {

    private final List<Dice> dices;

    protected enum NumberOfAKind{
        TWO(2L),
        THREE(3L),
        FOUR(4L);
        public final Long value;
        NumberOfAKind(Long value) {
            this.value = value;
        }
    }

    public XOfAKindScore(List<Dice> dices) {
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");


        this.dices = dices;
    }


    protected Score score(NumberOfAKind numberOfAKind) {
        if(numberOfAKind == null)
            throw new IllegalArgumentException("numberOfAKind is mandatory !");

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
