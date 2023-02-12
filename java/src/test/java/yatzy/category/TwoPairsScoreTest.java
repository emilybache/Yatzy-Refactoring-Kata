package yatzy.category;

import org.junit.Test;
import yatzy.Dice;
import yatzy.Score;
import yatzy.TestHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoPairsScoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4);
        new TwoPairsScore(dices);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dices_is_null() {
        new TwoPairsScore(null);
    }

    @Test
    public void two_pairs_several_scores() {
        assertEquals(Score.of(16), new TwoPairsScore(TestHelper.getDices(1,3,3,5,5)).score());
        assertEquals(Score.of(20), new TwoPairsScore(TestHelper.getDices(4,4,3,6,6)).score());
        assertEquals(Score.of(6), new TwoPairsScore(TestHelper.getDices(1,1,1,2,2)).score());
    }

    @Test
    public void two_pairs_scores_0() {
        assertEquals(Score.of(0), new TwoPairsScore(TestHelper.getDices(5,5,5,5,1)).score());
        assertEquals(Score.of(0), new TwoPairsScore(TestHelper.getDices(2,3,4,5,6)).score());
        assertEquals(Score.of(0), new TwoPairsScore(TestHelper.getDices(3,3,3,1,6)).score());
    }
}
