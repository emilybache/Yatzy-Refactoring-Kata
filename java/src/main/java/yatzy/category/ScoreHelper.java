package yatzy.category;

import yatzy.Dice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreHelper {

    public static Map<Dice, Long> getFrequencyOfEachDiceValue(List<Dice> dices){
        if(dices == null || dices.size() != 5)
            throw new IllegalArgumentException("we are waiting 5 dices !");

        return dices.stream()
            .collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }
}
