import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YatzyHelperTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = YatzyHelper.chance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, YatzyHelper.chance(3,3,4,5,1));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = YatzyHelper.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, YatzyHelper.yatzy(6,6,6,6,6));
        assertEquals(0, YatzyHelper.yatzy(6,6,6,6,3));
    }

    @Test public void test_1s() {
        assertTrue(YatzyHelper.ones(1,2,3,4,5) == 1);
        assertEquals(2, YatzyHelper.ones(1,2,1,4,5));
        assertEquals(0, YatzyHelper.ones(6,2,2,4,5));
        assertEquals(4, YatzyHelper.ones(1,2,1,1,1));
    }

    @Test
    public void test_2s() {
        assertEquals(4, YatzyHelper.twos(1,2,3,2,6));
        assertEquals(10, YatzyHelper.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, YatzyHelper.threes(1,2,3,2,3));
        assertEquals(12, YatzyHelper.threes(2,3,3,3,3));
    }
}
