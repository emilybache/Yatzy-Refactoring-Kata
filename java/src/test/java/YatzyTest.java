import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance_ReturnsSumOfAllDice() {
        int expected1 = 15;
        int expected2 = 16;
        assertEquals(expected1, Yatzy.chance(2,3,4,5,1));
        assertEquals(expected2, Yatzy.chance(3,3,4,5,1));
    }

    @Test public void yatzy_return50_ifAllDieAreEqual() {
        int expected = 50;
        assertEquals(expected, Yatzy.yatzy(4,4,4,4,4));
        assertEquals(expected, Yatzy.yatzy(6,6,6,6,6));
    }

    @Test public void yatzy_return0_ifAtLeastOneDieIsDifferent() {
        int expected = 0;
        assertEquals(expected, Yatzy.yatzy(6,6,6,6,3));
    }

    @Test public void ones_returnsSumOfOnes() {
        assertEquals(1, Yatzy.ones(1,2,3,4,5));
        assertEquals(2, Yatzy.ones(1,2,1,4,5));
        assertEquals(0, Yatzy.ones(6,2,2,4,5));
        assertEquals(4, Yatzy.ones(1,2,1,1,1));
    }

    @Test
    public void twos_returnsSumOfTwos() {
        assertEquals(4, Yatzy.twos(1,2,3,2,6));
        assertEquals(10, Yatzy.twos(2,2,2,2,2));
    }

    @Test
    public void threes_returnSumOfThrees() {
        assertEquals(6, Yatzy.threes(1,2,3,2,3));
        assertEquals(12, Yatzy.threes(2,3,3,3,3));
    }

    @Test
    public void fours_returnSumOfFours() {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void fives_returnSumOfFours() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_returnSumOfSixes() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void onePair_returnsTheSumOfDiceFoundInPair() {
        assertEquals(6, Yatzy.scorePair(3,4,3,5,6));
        assertEquals(10, Yatzy.scorePair(5,3,3,3,5));
        assertEquals(12, Yatzy.scorePair(5,3,6,6,5));
    }

    @Test
    public void twoPair_returnsTheSumOfDiceFoundInTwoPairs() {
        assertEquals(16, Yatzy.twoPair(3,3,5,4,5));
        assertEquals(16, Yatzy.twoPair(3,3,5,5,5));
    }

    @Test
    public void threeOfAKind_returnsTheSumOfTheSameDieFoundThreeTimes() {
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,4,5));
        assertEquals(15, Yatzy.threeOfAKind(5,3,5,4,5));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,3,5));
    }

    @Test
    public void fourOfAKind_returnTheSumOfTheSameDieFoundFourTimes() {
        assertEquals(12, Yatzy.fourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy.fourOfAKind(5,5,5,4,5));
        assertEquals(12, Yatzy.fourOfAKind(3,3,3,3,3));
    }

    @Test
    public void smallStraight_returns15_ifSmallStraight_otherwise0() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight_returns20_ifLargeStraight_otherwise0() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse_returnsSum_IfThreeDiceAndTheTwoOtherDiceAreOfTheSameNumber_Otherwise0() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
