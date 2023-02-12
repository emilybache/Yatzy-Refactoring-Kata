package yatzy.category;

import org.junit.Test;
import yatzy.Dice;
import yatzy.Score;
import yatzy.TestHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChanceScoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4);
        new ChanceScore(dices);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dices_is_null() {
        new ChanceScore(null);
    }
    @Test
    public void chance_scores_15_sum_of_all_dice() {
        List<Dice> dices = TestHelper.getDices(2,3,4,5,1);

        Score expected = Score.of(15);
        Score actual = new ChanceScore(dices).score();
        assertEquals(expected, actual);

    }

    @Test
    public void chance_scores_16_sum_of_all_dice() {
        List<Dice> dices = TestHelper.getDices(3,3,4,5,1);

        Score expected = Score.of(16);
        Score actual = new ChanceScore(dices).score();
        assertEquals(expected, actual);

    }
}
