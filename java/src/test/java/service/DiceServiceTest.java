package service;

import model.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiceServiceTest {

    private DiceService diceServiceUnderTest;

    @BeforeEach
    void setUp() {
        diceServiceUnderTest = new DiceService();
    }

    @Test
    public void areAllTheSame_shouldReturnTrue_ifAllTheDieAreTheSame_otherwiseFalse() {
        Dice dice1 = new Dice(4,4,4,4,4);
        Dice dice2 = new Dice(6,1,1,1,6);

        assertTrue(diceServiceUnderTest.areAllTheSame(dice1));
        assertFalse(diceServiceUnderTest.areAllTheSame(dice2));
    }

    @Test
    public void sum_returnsSumOfDice() {
        Dice dice1 = new Dice(2,3,4,5,1);

        assertEquals(15, diceServiceUnderTest.sum(dice1));
    }

    @Test
    public void isSmallStraight_checkifItsASmallStraight() {
        Dice dice1 = new Dice(2,3,4,5,1);
        Dice dice2 = new Dice(1,2,2,4,5);

        assertTrue(diceServiceUnderTest.isSmallStraight(dice1));
        assertFalse(diceServiceUnderTest.isSmallStraight(dice2));
    }

    @Test
    public void isLargeStraight_checkifItsALargeStraight() {
        Dice dice1 = new Dice(2,3,4,5,6);
        Dice dice2 = new Dice(1,2,2,4,5);

        assertTrue(diceServiceUnderTest.isLargeStraight(dice1));
        assertFalse(diceServiceUnderTest.isLargeStraight(dice2));
    }

    @Test
    public void getSumOfXsInDice_returnTheSumOfXsInTheProvidedDice() {
        Dice dice = new Dice(1,2,2,4,5);

        assertEquals(4, diceServiceUnderTest.getSumOfXsInDice(2, dice));
    }

    @Test
    public void getListdistinctDieFoundMoreThenXTimes_returnTheListOfDieFoundMoreThenXTimes() {
        Dice dice = new Dice(1,2,2,4,5);

        List<Integer> expectedList = List.of(2);

        assertEquals(expectedList, diceServiceUnderTest.getListdistinctDieFoundMoreThenXTimes(dice, 2));
    }

    @Test
    public void getListdistinctDieFoundOnlyXTimes_returnTheListOfDieFoundMoreThenXTimes() {
        Dice dice = new Dice(1,3,3,4,5);

        List<Integer> expectedList = List.of(3);

        assertEquals(expectedList, diceServiceUnderTest.getListdistinctDieFoundOnlyXTimes(dice, 2));
    }

}
