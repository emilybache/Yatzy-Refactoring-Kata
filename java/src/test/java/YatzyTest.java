import org.junit.Test;
import yatzy.Dice;
import yatzy.Score;
import yatzy.TestHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = TestHelper.getDices(1,2,3,4);
        new Yatzy(dices);
    }

    @Test
    public void chance_scores_sum_of_all_dice() {
        Score expected = Score.of(15);
        Score actual = new Yatzy(TestHelper.getDices(2,3,4,5,1)).chance();
        assertEquals(expected, actual);
        assertEquals(Score.of(16), new Yatzy(TestHelper.getDices(3,3,4,5,1)).chance());
    }

    @Test public void yatzy_scores_50() {
        Score expected = Score.of(50);
        Score actual = new Yatzy(TestHelper.getDices(4,4,4,4,4)).yatzy();
        assertEquals(expected, actual);
        assertEquals(Score.of(50), new Yatzy(TestHelper.getDices(6,6,6,6,6)).yatzy());
        assertEquals(Score.of(0), new Yatzy(TestHelper.getDices(6,6,6,6,3)).yatzy());
    }

    @Test public void test_1s() {
        assertEquals(Score.of(1),new Yatzy(TestHelper.getDices(1,2,3,4,5)).ones());
        assertEquals(Score.of(2), new Yatzy(TestHelper.getDices(1,2,1,4,5)).ones());
        assertEquals(Score.of(0), new Yatzy(TestHelper.getDices(6,2,2,4,5)).ones());
        assertEquals(Score.of(4), new Yatzy(TestHelper.getDices(1,2,1,1,1)).ones());
    }

    @Test
    public void test_2s() {
        assertEquals(Score.of(4), new Yatzy(TestHelper.getDices(1,2,3,2,6)).twos());
        assertEquals(Score.of(10), new Yatzy(TestHelper.getDices(2,2,2,2,2)).twos());
    }

    @Test
    public void test_threes() {
        assertEquals(Score.of(6), new Yatzy(TestHelper.getDices(1,2,3,2,3)).threes());
        assertEquals(Score.of(12), new Yatzy(TestHelper.getDices(2,3,3,3,3)).threes());
    }

    @Test
    public void fours_test() 
    {
        assertEquals(Score.of(12), new Yatzy(TestHelper.getDices(4,4,4,5,5)).fours());
        assertEquals(Score.of(8), new Yatzy(TestHelper.getDices(4,4,5,5,5)).fours());
        assertEquals(Score.of(4), new Yatzy(TestHelper.getDices(4,5,5,5,5)).fours());
    }

    @Test
    public void fives() {
        assertEquals(Score.of(10), new Yatzy(TestHelper.getDices(4,4,4,5,5)).fives());
        assertEquals(Score.of(15), new Yatzy(TestHelper.getDices(4,4,5,5,5)).fives());
        assertEquals(Score.of(20), new Yatzy(TestHelper.getDices(4,5,5,5,5)).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(Score.of(0), new Yatzy(TestHelper.getDices(4,4,4,5,5)).sixes());
        assertEquals(Score.of(6), new Yatzy(TestHelper.getDices(4,4,6,5,5)).sixes());
        assertEquals(Score.of(18), new Yatzy(TestHelper.getDices(6,5,6,6,5)).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(Score.of(6), new Yatzy(TestHelper.getDices(3,4,3,5,6)).score_pair());
        assertEquals(Score.of(10), new Yatzy(TestHelper.getDices(5,3,3,3,5)).score_pair());
        assertEquals(Score.of(12), new Yatzy(TestHelper.getDices(5,3,6,6,5)).score_pair());
    }

    @Test
    public void two_Pair() {
        assertEquals(Score.of(16), new Yatzy(TestHelper.getDices(3,3,5,4,5)).two_pair());
        assertEquals(Score.of(16), new Yatzy(TestHelper.getDices(3,3,5,5,5)).two_pair());
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(Score.of(9), new Yatzy(TestHelper.getDices(3,3,3,4,5)).three_of_a_kind());
        assertEquals(Score.of(15), new Yatzy(TestHelper.getDices(5,3,5,4,5)).three_of_a_kind());
        assertEquals(Score.of(9), new Yatzy(TestHelper.getDices(3,3,3,3,5)).three_of_a_kind());
    }

    @Test
    public void four_of_a_kind() {
        assertEquals(Score.of(12), new Yatzy(TestHelper.getDices(3,3,3,3,5)).four_of_a_kind());
        assertEquals(Score.of(20), new Yatzy(TestHelper.getDices(5,5,5,4,5)).four_of_a_kind());
        assertEquals(Score.of(12), new Yatzy(TestHelper.getDices(3,3,3,3,3)).four_of_a_kind());
    }

    @Test
    public void smallStraight() {
        assertEquals(Score.of(15), new Yatzy(TestHelper.getDices(1,2,3,4,5)).smallStraight());
        assertEquals(Score.of(15), new Yatzy(TestHelper.getDices(2,3,4,5,1)).smallStraight());
        assertEquals(Score.of(0), new Yatzy(TestHelper.getDices(1,2,2,4,5)).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(Score.of(20), new Yatzy(TestHelper.getDices(6,2,3,4,5)).largeStraight());
        assertEquals(Score.of(20), new Yatzy(TestHelper.getDices(2,3,4,5,6)).largeStraight());
        assertEquals(Score.of(0), new Yatzy(TestHelper.getDices(1,2,2,4,5)).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(Score.of(18), new Yatzy(TestHelper.getDices(6,2,2,2,6)).fullHouse());
        assertEquals(Score.of(0), new Yatzy(TestHelper.getDices(2,3,4,5,6)).fullHouse());
    }
}
