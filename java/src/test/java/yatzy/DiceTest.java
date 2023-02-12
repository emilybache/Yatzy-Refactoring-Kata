package yatzy;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dice_value_is_greather_than_6() {
        Dice.of(15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dice_value_is_lower_than_1() {
        Dice.of(0);
    }

    @Test public void test_good_values() {
        assertEquals(Integer.valueOf(1), Dice.of(1).getValue());
        assertEquals(Integer.valueOf(2), Dice.of(2).getValue());
        assertEquals(Integer.valueOf(3), Dice.of(3).getValue());
        assertEquals(Integer.valueOf(4), Dice.of(4).getValue());
        assertEquals(Integer.valueOf(5), Dice.of(5).getValue());
        assertEquals(Integer.valueOf(6), Dice.of(6).getValue());


    }
}
