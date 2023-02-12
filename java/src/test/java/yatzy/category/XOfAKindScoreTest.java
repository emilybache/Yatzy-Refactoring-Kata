package yatzy.category;

import org.junit.Test;
import yatzy.Dice;
import yatzy.Score;
import yatzy.TestHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class XOfAKindScoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4);
        new XOfAKindScore(dices, XOfAKindScore.NumberOfAKind.TWO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dices_is_null() {
        new XOfAKindScore(null, XOfAKindScore.NumberOfAKind.FOUR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_numberOfAKind_is_null() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4,5);
        new XOfAKindScore(dices, null);
    }

    @Test
    public void two_number_of_kind() {
        assertEquals(Score.of(2), new XOfAKindScore(TestHelper.getDices(1,1,1,1,1), XOfAKindScore.NumberOfAKind.TWO).score());
        assertEquals(Score.of(10), new XOfAKindScore(TestHelper.getDices(5,1,5,1,5), XOfAKindScore.NumberOfAKind.TWO).score());
        assertEquals(Score.of(4), new XOfAKindScore(TestHelper.getDices(2,2,1,1,2), XOfAKindScore.NumberOfAKind.TWO).score());
        assertEquals(Score.of(4), new XOfAKindScore(TestHelper.getDices(2,4,1,1,2), XOfAKindScore.NumberOfAKind.TWO).score());
        assertEquals(Score.of(6), new XOfAKindScore(TestHelper.getDices(2,4,3,1,3), XOfAKindScore.NumberOfAKind.TWO).score());
        assertEquals(Score.of(0), new XOfAKindScore(TestHelper.getDices(2,4,3,1,5), XOfAKindScore.NumberOfAKind.TWO).score());
    }

    @Test
    public void three_number_of_kind() {
        assertEquals(Score.of(3), new XOfAKindScore(TestHelper.getDices(1,1,1,1,1), XOfAKindScore.NumberOfAKind.THREE).score());
        assertEquals(Score.of(15), new XOfAKindScore(TestHelper.getDices(5,1,5,1,5), XOfAKindScore.NumberOfAKind.THREE).score());
        assertEquals(Score.of(6), new XOfAKindScore(TestHelper.getDices(2,2,1,1,2), XOfAKindScore.NumberOfAKind.THREE).score());
        assertEquals(Score.of(0), new XOfAKindScore(TestHelper.getDices(2,4,1,1,2), XOfAKindScore.NumberOfAKind.THREE).score());
    }

    @Test
    public void four_number_of_kind() {
        assertEquals(Score.of(4), new XOfAKindScore(TestHelper.getDices(1,1,1,1,1), XOfAKindScore.NumberOfAKind.FOUR).score());
        assertEquals(Score.of(20), new XOfAKindScore(TestHelper.getDices(5,5,5,1,5), XOfAKindScore.NumberOfAKind.FOUR).score());
        assertEquals(Score.of(8), new XOfAKindScore(TestHelper.getDices(2,2,2,1,2), XOfAKindScore.NumberOfAKind.FOUR).score());
        assertEquals(Score.of(0), new XOfAKindScore(TestHelper.getDices(2,4,1,1,2), XOfAKindScore.NumberOfAKind.FOUR).score());
    }

}
