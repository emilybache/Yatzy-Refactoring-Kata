package yatzy.category;

import org.junit.Test;
import yatzy.Dice;
import yatzy.Score;
import yatzy.TestHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class YatziScoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4);
        new YatzyScore(dices);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dices_is_null() {
        new YatzyScore(null);
    }
    @Test
    public void yatzy_scores_50_with_1() {
        List<Dice> dices = TestHelper.getDices(1,1,1,1,1);

        Score expected = Score.of(50);
        Score actual = new YatzyScore(dices).score();
        assertEquals(expected, actual);
    }

    @Test
    public void yatzy_scores_50_with_5() {
        List<Dice> dices = TestHelper.getDices(5,5,5,5,5);

        Score expected = Score.of(50);
        Score actual = new YatzyScore(dices).score();
        assertEquals(expected, actual);
    }

    @Test
    public void yatzy_scores_0() {
        List<Dice> dices = TestHelper.getDices(5,5,5,5,1);

        Score expected = Score.of(0);
        Score actual = new YatzyScore(dices).score();
        assertEquals(expected, actual);
    }
}
