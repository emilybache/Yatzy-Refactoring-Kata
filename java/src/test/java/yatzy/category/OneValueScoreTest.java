package yatzy.category;

import org.junit.Test;
import yatzy.Dice;
import yatzy.Score;
import yatzy.TestHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OneValueScoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4);
        Dice readDice = Dice.of(1);
        new OneValueScore(dices, readDice);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dices_is_null() {
        Dice readDice = Dice.of(1);
        new OneValueScore(null, readDice);
    }
    @Test(expected = IllegalArgumentException.class)
    public void throws_if_read_dice_is_null() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4,5);
        new OneValueScore(dices, null);
    }

    @Test public void test_read_dice_is_1() {
        Dice readDice = Dice.of(1);
        assertEquals(Score.of(1), new OneValueScore(TestHelper.getDices(1,2,3,4,5), readDice).score());
        assertEquals(Score.of(2), new OneValueScore(TestHelper.getDices(1,2,1,4,5), readDice).score());
        assertEquals(Score.of(0), new OneValueScore(TestHelper.getDices(6,2,2,4,5), readDice).score());
        assertEquals(Score.of(4), new OneValueScore(TestHelper.getDices(1,2,1,1,1), readDice).score());
    }

    @Test public void test_read_dice_is_2() {
        Dice readDice = Dice.of(2);
        assertEquals(Score.of(4), new OneValueScore(TestHelper.getDices(1,2,3,2,6), readDice).score());
        assertEquals(Score.of(10), new OneValueScore(TestHelper.getDices(2,2,2,2,2), readDice).score());
    }

    @Test public void test_read_dice_is_3() {
        Dice readDice = Dice.of(3);
        assertEquals(Score.of(6), new OneValueScore(TestHelper.getDices(1,2,3,2,3), readDice).score());
        assertEquals(Score.of(12), new OneValueScore(TestHelper.getDices(2,3,3,3,3), readDice).score());
    }

    @Test public void test_read_dice_is_4() {
        Dice readDice = Dice.of(4);
        assertEquals(Score.of(12), new OneValueScore(TestHelper.getDices(4,4,4,5,5), readDice).score());
        assertEquals(Score.of(8), new OneValueScore(TestHelper.getDices(4,4,5,5,5), readDice).score());
        assertEquals(Score.of(4), new OneValueScore(TestHelper.getDices(4,5,5,5,5), readDice).score());
    }

    @Test public void test_read_dice_is_5() {
        Dice readDice = Dice.of(5);
        assertEquals(Score.of(10), new OneValueScore(TestHelper.getDices(4,4,4,5,5), readDice).score());
        assertEquals(Score.of(15), new OneValueScore(TestHelper.getDices(4,4,5,5,5), readDice).score());
        assertEquals(Score.of(20), new OneValueScore(TestHelper.getDices(4,5,5,5,5), readDice).score());
    }

    @Test public void test_read_dice_is_6() {
        Dice readDice = Dice.of(6);
        assertEquals(Score.of(0), new OneValueScore(TestHelper.getDices(4,4,4,5,5), readDice).score());
        assertEquals(Score.of(6), new OneValueScore(TestHelper.getDices(4,4,6,5,5), readDice).score());
        assertEquals(Score.of(18), new OneValueScore(TestHelper.getDices(6,2,6,4,6), readDice).score());
    }
}
