package yatzy.category;

import org.junit.Test;
import yatzy.Dice;
import yatzy.Score;
import yatzy.TestHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FullHouseScoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4);
        new FullHouseScore(dices);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dices_is_null() {
        new FullHouseScore(null);
    }

    @Test
    public void full_house_several_scores() {
        assertEquals(Score.of(7), new FullHouseScore(TestHelper.getDices(1,1,1,2,2)).score());
        assertEquals(Score.of(19), new FullHouseScore(TestHelper.getDices(3,3,3,5,5)).score());
    }


    @Test
    public void full_house_scores_0() {
        assertEquals(Score.of(0), new FullHouseScore(TestHelper.getDices(5,5,5,5,1)).score());
        assertEquals(Score.of(0), new FullHouseScore(TestHelper.getDices(2,3,4,5,6)).score());
        assertEquals(Score.of(0), new FullHouseScore(TestHelper.getDices(2,3,4,1,6)).score());
    }
}
