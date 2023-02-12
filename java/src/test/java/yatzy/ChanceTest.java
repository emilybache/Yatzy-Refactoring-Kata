package yatzy;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChanceTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = List.of(Dice.of(1),Dice.of(1),Dice.of(1),Dice.of(1),Dice.of(1),Dice.of(1));

        new Chance(dices);
    }


    @Test
    public void chance_scores_15_sum_of_all_dice() {
        List<Dice> dices = List.of(
            Dice.of(2),Dice.of(3),
            Dice.of(4),Dice.of(5),Dice.of(1));

        Score expected = Score.of(15);
        Score actual = new Chance(dices).score();
        assertEquals(expected, actual);

    }

    @Test
    public void chance_scores_16_sum_of_all_dice() {
        List<Dice> dices = List.of(
            Dice.of(3),Dice.of(3),
            Dice.of(4),Dice.of(5),Dice.of(1));

        Score expected = Score.of(16);
        Score actual = new Chance(dices).score();
        assertEquals(expected, actual);

    }
}
