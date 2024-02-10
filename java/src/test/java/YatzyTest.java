import model.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    private Yatzy yatzyUnderTest;

    @BeforeEach
    void setUp() {
      this.yatzyUnderTest = new Yatzy();
    }

    @Test
    public void chance_ReturnsSumOfAllDice() {
        Dice dice1 = new Dice(2,3,4,5,1);
        Dice dice2 = new Dice(3,3,4,5,1);

        int expected1 = 15;
        int expected2 = 16;

        assertEquals(expected1, yatzyUnderTest.chance(dice1));
        assertEquals(expected2, yatzyUnderTest.chance(dice2));
    }

    @Test
    public void yatzy_return50_ifAllDieAreEqual() {
        Dice dice1 = new Dice(4,4,4,4,4);
        Dice dice2 = new Dice(6,6,6,6,6);

        int expected = 50;

        assertEquals(expected, yatzyUnderTest.yatzy(dice1));
        assertEquals(expected, yatzyUnderTest.yatzy(dice2));
    }

    @Test
    public void yatzy_return0_ifAtLeastOneDieIsDifferent() {
        Dice dice = new Dice(6,6,6,6,3);
        int expected = 0;
        assertEquals(expected, yatzyUnderTest.yatzy(dice));
    }

    @Test
    public void ones_returnsSumOfOnes() {
        assertEquals(1, yatzyUnderTest.ones(1,2,3,4,5));
        assertEquals(2, yatzyUnderTest.ones(1,2,1,4,5));
        assertEquals(0, yatzyUnderTest.ones(6,2,2,4,5));
        assertEquals(4, yatzyUnderTest.ones(1,2,1,1,1));
    }

    @Test
    public void twos_returnsSumOfTwos() {
        assertEquals(4, yatzyUnderTest.twos(1,2,3,2,6));
        assertEquals(10, yatzyUnderTest.twos(2,2,2,2,2));
    }

    @Test
    public void threes_returnSumOfThrees() {
        assertEquals(6, yatzyUnderTest.threes(1,2,3,2,3));
        assertEquals(12, yatzyUnderTest.threes(2,3,3,3,3));
    }

    @Test
    public void fours_returnSumOfFours() {
        assertEquals(12, yatzyUnderTest.fours(4,4,4,5,5));
        assertEquals(8, yatzyUnderTest.fours(4,4,5,5,5));
        assertEquals(4, yatzyUnderTest.fours(4,5,5,5,5));
    }

    @Test
    public void fives_returnSumOfFours() {
        assertEquals(10, yatzyUnderTest.fives(4,4,4,5,5));
        assertEquals(15, yatzyUnderTest.fives(4,4,5,5,5));
        assertEquals(20, yatzyUnderTest.fives(4,5,5,5,5));
    }

    @Test
    public void sixes_returnSumOfSixes() {

        assertEquals(0, yatzyUnderTest.sixes(4,4,4,5,5));
        assertEquals(6, yatzyUnderTest.sixes(4,4,6,5,5));
        assertEquals(18, yatzyUnderTest.sixes(6,5,6,6,5));
    }

    @Test
    public void onePair_returnsTheSumOfDiceFoundInPair() {
        assertEquals(6, yatzyUnderTest.scorePair(3,4,3,5,6));
        assertEquals(10, yatzyUnderTest.scorePair(5,3,3,3,5));
        assertEquals(12, yatzyUnderTest.scorePair(5,3,6,6,5));
    }

    @Test
    public void twoPair_returnsTheSumOfDiceFoundInTwoPairs() {
        assertEquals(16, yatzyUnderTest.twoPair(3,3,5,4,5));
        assertEquals(16, yatzyUnderTest.twoPair(3,3,5,5,5));
    }

    @Test
    public void threeOfAKind_returnsTheSumOfTheSameDieFoundThreeTimes() {
        assertEquals(9, yatzyUnderTest.threeOfAKind(3,3,3,4,5));
        assertEquals(15, yatzyUnderTest.threeOfAKind(5,3,5,4,5));
        assertEquals(9, yatzyUnderTest.threeOfAKind(3,3,3,3,5));
    }

    @Test
    public void fourOfAKind_returnTheSumOfTheSameDieFoundFourTimes() {
        assertEquals(12, yatzyUnderTest.fourOfAKind(3,3,3,3,5));
        assertEquals(20, yatzyUnderTest.fourOfAKind(5,5,5,4,5));
        assertEquals(12, yatzyUnderTest.fourOfAKind(3,3,3,3,3));
    }

    @Test
    public void smallStraight_returns15_ifSmallStraight_otherwise0() {
        assertEquals(15, yatzyUnderTest.smallStraight(1,2,3,4,5));
        assertEquals(15, yatzyUnderTest.smallStraight(2,3,4,5,1));
        assertEquals(0, yatzyUnderTest.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight_returns20_ifLargeStraight_otherwise0() {
        assertEquals(20, yatzyUnderTest.largeStraight(6,2,3,4,5));
        assertEquals(20, yatzyUnderTest.largeStraight(2,3,4,5,6));
        assertEquals(0, yatzyUnderTest.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse_returnsSum_IfThreeDiceAndTheTwoOtherDiceAreOfTheSameNumber_Otherwise0() {
        assertEquals(18, yatzyUnderTest.fullHouse(6,2,2,2,6));
        assertEquals(0, yatzyUnderTest.fullHouse(2,3,4,5,6));
    }
}
