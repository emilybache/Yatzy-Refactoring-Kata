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
        Dice dice1 = new Dice(1,2,3,4,5);
        Dice dice2 = new Dice(1,2,1,4,5);
        Dice dice3 = new Dice(6,2,2,4,5);
        Dice dice4 = new Dice(1,2,1,1,1);

        assertEquals(1, yatzyUnderTest.ones(dice1));
        assertEquals(2, yatzyUnderTest.ones(dice2));
        assertEquals(0, yatzyUnderTest.ones(dice3));
        assertEquals(4, yatzyUnderTest.ones(dice4));
    }

    @Test
    public void twos_returnsSumOfTwos() {
        Dice dice1 = new Dice(1,2,3,2,6);
        Dice dice2 = new Dice(2,2,2,2,2);

        assertEquals(4, yatzyUnderTest.twos(dice1));
        assertEquals(10, yatzyUnderTest.twos(dice2));
    }

    @Test
    public void threes_returnSumOfThrees() {
        Dice dice1 = new Dice(1,2,3,2,3);
        Dice dice2 = new Dice(2,3,3,3,3);

        assertEquals(6, yatzyUnderTest.threes(dice1));
        assertEquals(12, yatzyUnderTest.threes(dice2));
    }

    @Test
    public void fours_returnSumOfFours() {
        Dice dice1 = new Dice(4,4,4,5,5);
        Dice dice2 = new Dice(4,4,5,5,5);
        Dice dice3 = new Dice(4,5,5,5,5);

        assertEquals(12, yatzyUnderTest.fours(dice1));
        assertEquals(8, yatzyUnderTest.fours(dice2));
        assertEquals(4, yatzyUnderTest.fours(dice3));
    }

    @Test
    public void fives_returnSumOfFours() {
        Dice dice1 = new Dice(4,4,4,5,5);
        Dice dice2 = new Dice(4,4,5,5,5);
        Dice dice3 = new Dice(4,5,5,5,5);

        assertEquals(10, yatzyUnderTest.fives(dice1));
        assertEquals(15, yatzyUnderTest.fives(dice2));
        assertEquals(20, yatzyUnderTest.fives(dice3));
    }

    @Test
    public void sixes_returnSumOfSixes() {
        Dice dice1 = new Dice(4,4,4,5,5);
        Dice dice2 = new Dice(4,4,6,5,5);
        Dice dice3 = new Dice(6,5,6,6,5);

        assertEquals(0, yatzyUnderTest.sixes(dice1));
        assertEquals(6, yatzyUnderTest.sixes(dice2));
        assertEquals(18, yatzyUnderTest.sixes(dice3));
    }

    @Test
    public void onePair_returnsTheSumOfDiceFoundInPair() {
        Dice dice1 = new Dice(3,4,3,5,6);
        Dice dice2 = new Dice(5,3,3,3,5);
        Dice dice3 = new Dice(5,3,6,6,5);

        assertEquals(6, yatzyUnderTest.onePair(dice1));
        assertEquals(10, yatzyUnderTest.onePair(dice2));
        assertEquals(12, yatzyUnderTest.onePair(dice3));
    }

    @Test
    public void twoPair_returnsTheSumOfDiceFoundInTwoPairs() {
        Dice dice1 = new Dice(3,3,5,4,5);
        Dice dice2 = new Dice(3,3,5,5,5);

        assertEquals(16, yatzyUnderTest.twoPairs(dice1));
        assertEquals(16, yatzyUnderTest.twoPairs(dice2));
    }

    @Test
    public void threeOfAKind_returnsTheSumOfTheSameDieFoundThreeTimes() {
        Dice dice1 = new Dice(3,3,3,4,5);
        Dice dice2 = new Dice(5,3,5,4,5);
        Dice dice3 = new Dice(3,3,3,3,5);

        assertEquals(9, yatzyUnderTest.threeOfAKind(dice1));
        assertEquals(15, yatzyUnderTest.threeOfAKind(dice2));
        assertEquals(9, yatzyUnderTest.threeOfAKind(dice3));
    }

    @Test
    public void fourOfAKind_returnTheSumOfTheSameDieFoundFourTimes() {
        Dice dice1 = new Dice(3,3,3,3,5);
        Dice dice2 = new Dice(5,5,5,4,5);
        Dice dice3 = new Dice(3,3,3,3,3);

        assertEquals(12, yatzyUnderTest.fourOfAKind(dice1));
        assertEquals(20, yatzyUnderTest.fourOfAKind(dice2));
        assertEquals(12, yatzyUnderTest.fourOfAKind(dice3));
    }

    @Test
    public void smallStraight_returns15_ifSmallStraight_otherwise0() {
        Dice dice1 = new Dice(1,2,3,4,5);
        Dice dice2 = new Dice(2,3,4,5,1);
        Dice dice3 = new Dice(1,2,2,4,5);

        assertEquals(15, yatzyUnderTest.smallStraight(dice1));
        assertEquals(15, yatzyUnderTest.smallStraight(dice2));
        assertEquals(0, yatzyUnderTest.smallStraight(dice3));
    }

    @Test
    public void largeStraight_returns20_ifLargeStraight_otherwise0() {
        Dice dice1 = new Dice(6,2,3,4,5);
        Dice dice2 = new Dice(2,3,4,5,6);
        Dice dice3 = new Dice(1,2,2,4,5);

        assertEquals(20, yatzyUnderTest.largeStraight(dice1));
        assertEquals(20, yatzyUnderTest.largeStraight(dice2));
        assertEquals(0, yatzyUnderTest.largeStraight(dice3));
    }

    @Test
    public void fullHouse_returnsSum_IfThreeDiceAndTheTwoOtherDiceAreOfTheSameNumber_Otherwise0() {
        Dice dice1 = new Dice(6,2,2,2,6);
        Dice dice2 = new Dice(2,3,4,5,6);

        assertEquals(18, yatzyUnderTest.fullHouse(dice1));
        assertEquals(0, yatzyUnderTest.fullHouse(dice2));
    }
}
