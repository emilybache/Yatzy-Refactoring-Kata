import org.junit.*;
import yatzyGameCategories.YatzyCategoryEnum;

import static org.junit.Assert.*;

public class YatzyGameTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = new YatzyGame(2,3,4,5,1, YatzyCategoryEnum.CHANCE).calculateScore();
        assertEquals(expected, actual);
        assertEquals(16, new YatzyGame(3,3,4,5,1, YatzyCategoryEnum.CHANCE).calculateScore());
    }

    @Test public void yatzy_scores_50_with_correct_dice_sets() {
        assertEquals(50, new YatzyGame(4,4,4,4,4, YatzyCategoryEnum.YATZY).calculateScore());
        assertEquals(50, new YatzyGame(6,6,6,6,6, YatzyCategoryEnum.YATZY).calculateScore());
    }
    @Test public void yatzy_scores_0_with_incorrect_dice_sets() {
        assertEquals(0, new YatzyGame(6,6,6,6,3, YatzyCategoryEnum.YATZY).calculateScore());
        assertEquals(0, new YatzyGame(6,2,6,6,3, YatzyCategoryEnum.YATZY).calculateScore());
    }

    @Test public void test_OneGameCategories() {
        assertTrue(new YatzyGame(1,2,3,4,5, YatzyCategoryEnum.ONES).calculateScore() == 1);
        assertEquals(2, new YatzyGame(1,2,1,4,5, YatzyCategoryEnum.ONES).calculateScore());
        assertEquals(0, new YatzyGame(6,2,2,4,5, YatzyCategoryEnum.ONES).calculateScore());
        assertEquals(4, new YatzyGame(1,2,1,1,1, YatzyCategoryEnum.ONES).calculateScore());
    }

    @Test
    public void test_TwoGameCategories() {
        assertEquals(4, new YatzyGame(1,2,3,2,6, YatzyCategoryEnum.TWOS).calculateScore());
        assertEquals(10, new YatzyGame(2,2,2,2,2, YatzyCategoryEnum.TWOS).calculateScore());
    }

    @Test
    public void test_ThreeGameCategories() {
        assertEquals(6, new YatzyGame(1,2,3,2,3, YatzyCategoryEnum.THREES).calculateScore());
        assertEquals(12, new YatzyGame(2,3,3,3,3, YatzyCategoryEnum.THREES).calculateScore());
    }

    @Test
    public void test_FoursGameCategories()
    {
        assertEquals(12, new YatzyGame(4,4,4,5,5, YatzyCategoryEnum.FOURS).calculateScore());
        assertEquals(8, new YatzyGame(4,4,5,5,5, YatzyCategoryEnum.FOURS).calculateScore());
        assertEquals(4, new YatzyGame(4,5,5,5,5, YatzyCategoryEnum.FOURS).calculateScore());
    }

    @Test
    public void test_FivesGameCategories() {
        assertEquals(10, new YatzyGame(4,4,4,5,5, YatzyCategoryEnum.FIVES).calculateScore());
        assertEquals(15, new YatzyGame(4,4,5,5,5, YatzyCategoryEnum.FIVES).calculateScore());
        assertEquals(20, new YatzyGame(4,5,5,5,5, YatzyCategoryEnum.FIVES).calculateScore());
    }

    @Test
    public void test_SixesGameCategories() {
        assertEquals(0, new YatzyGame(4,4,4,5,5, YatzyCategoryEnum.SIXES).calculateScore());
        assertEquals(6, new YatzyGame(4,4,6,5,5, YatzyCategoryEnum.SIXES).calculateScore());
        assertEquals(18, new YatzyGame(6,5,6,6,5, YatzyCategoryEnum.SIXES).calculateScore());
    }

    @Test
    public void test_OnePairGameCategories() {
        assertEquals(6, new YatzyGame(3,4,3,5,6, YatzyCategoryEnum.PAIR).calculateScore());
        assertEquals(10, new YatzyGame(5,3,3,3,5, YatzyCategoryEnum.PAIR).calculateScore());
        assertEquals(12, new YatzyGame(5,3,6,6,5, YatzyCategoryEnum.PAIR).calculateScore());
        assertEquals(0, new YatzyGame(1,3,6,2,5, YatzyCategoryEnum.PAIR).calculateScore());

    }

    @Test
    public void test_TwoPairGameCategories() {
        assertEquals(16, new YatzyGame(3,3,5,4,5, YatzyCategoryEnum.TOW_PAIR).calculateScore());
        assertEquals(16, new YatzyGame(3,3,5,5,5, YatzyCategoryEnum.TOW_PAIR).calculateScore());
        assertEquals(16, new YatzyGame(3,3,2,5,5, YatzyCategoryEnum.TOW_PAIR).calculateScore());
        assertEquals(0, new YatzyGame(1,3,2,5,5, YatzyCategoryEnum.TOW_PAIR).calculateScore());
    }

    @Test
    public void test_ThreeOfKindGameCategories()
    {
        assertEquals(9, new YatzyGame(3,3,3,4,5, YatzyCategoryEnum.THREE_OF_KIND).calculateScore());
        assertEquals(15, new YatzyGame(5,3,5,4,5, YatzyCategoryEnum.THREE_OF_KIND).calculateScore());
        assertEquals(9, new YatzyGame(3,3,3,3,5, YatzyCategoryEnum.THREE_OF_KIND).calculateScore());
        assertEquals(0, new YatzyGame(1,2,3,3,5, YatzyCategoryEnum.THREE_OF_KIND).calculateScore());
    }

    @Test
    public void test_FourOfKindGameCategories() {
        assertEquals(12, new YatzyGame(3,3,3,3,5, YatzyCategoryEnum.FOUR_OF_KIND).calculateScore());
        assertEquals(20, new YatzyGame(5,5,5,4,5, YatzyCategoryEnum.FOUR_OF_KIND).calculateScore());
        assertEquals(12, new YatzyGame(3,3,3,3,3, YatzyCategoryEnum.FOUR_OF_KIND).calculateScore());
        assertEquals(0, new YatzyGame(3,1,2,3,3, YatzyCategoryEnum.FOUR_OF_KIND).calculateScore());
    }

    @Test
    public void test_SamllStraightGameCategories() {
    assertEquals(15, new YatzyGame(1,2,3,4,5, YatzyCategoryEnum.SMALL_STRAIGHT).calculateScore());
        assertEquals(15, new YatzyGame(2,3,4,5,1, YatzyCategoryEnum.SMALL_STRAIGHT).calculateScore());
        assertEquals(0, new YatzyGame(1,2,2,4,5, YatzyCategoryEnum.SMALL_STRAIGHT).calculateScore());
    }

    @Test
    public void test_LargetraightGameCategories() {
        assertEquals(20, new YatzyGame(6,2,3,4,5, YatzyCategoryEnum.LARGE_STRAIGHT).calculateScore());
        assertEquals(20, new YatzyGame(2,3,4,5,6, YatzyCategoryEnum.LARGE_STRAIGHT).calculateScore());
        assertEquals(0, new YatzyGame(1,2,2,4,5, YatzyCategoryEnum.LARGE_STRAIGHT).calculateScore());
    }

    @Test
    public void test_FullHouseGameCategories() {
        assertEquals(18, new YatzyGame(6,2,2,2,6, YatzyCategoryEnum.FULL_HOUSE).calculateScore());
        assertEquals(0, new YatzyGame(2,3,4,5,6,  YatzyCategoryEnum.FULL_HOUSE).calculateScore());
    }
}
