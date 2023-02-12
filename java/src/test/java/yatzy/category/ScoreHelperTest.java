package yatzy.category;

import org.junit.Test;
import yatzy.Dice;
import yatzy.TestHelper;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScoreHelperTest {

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_number_of_dice_is_different_of_5() {
        List<Dice> dices = List.of(Dice.of(1),Dice.of(1),Dice.of(1),Dice.of(1),Dice.of(1),Dice.of(1));

        ScoreHelper.getFrequencyOfEachDiceValue(dices);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_dices_is_null() {
        ScoreHelper.getFrequencyOfEachDiceValue(null);
    }
    @Test
    public void count_with_one_value(){
        Map<Dice, Long> counts = ScoreHelper.getFrequencyOfEachDiceValue(TestHelper.getDices(1,1,1,1,1));

        assertEquals(1, counts.size());
        assertTrue(counts.containsKey(Dice.of(1)));
        assertEquals(Long.valueOf(5), counts.get(Dice.of(1)));
    }

    @Test
    public void count_with_two_values(){
        Map<Dice, Long> counts = ScoreHelper.getFrequencyOfEachDiceValue(TestHelper.getDices(1,1,1,2,2));

        assertEquals(2, counts.size());
        assertTrue(counts.containsKey(Dice.of(1)));
        assertTrue(counts.containsKey(Dice.of(2)));
        assertEquals(Long.valueOf(3), counts.get(Dice.of(1)));
        assertEquals(Long.valueOf(2), counts.get(Dice.of(2)));
    }

    @Test
    public void count_with_three_values(){
        Map<Dice, Long> counts = ScoreHelper.getFrequencyOfEachDiceValue(TestHelper.getDices(3,4,4,5,5));

        assertEquals(3, counts.size());
        assertTrue(counts.containsKey(Dice.of(3)));
        assertTrue(counts.containsKey(Dice.of(4)));
        assertTrue(counts.containsKey(Dice.of(5)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(3)));
        assertEquals(Long.valueOf(2), counts.get(Dice.of(4)));
        assertEquals(Long.valueOf(2), counts.get(Dice.of(5)));
    }

    @Test
    public void count_with_four_values(){
        Map<Dice, Long> counts = ScoreHelper.getFrequencyOfEachDiceValue(TestHelper.getDices(3,4,4,5,2));

        assertEquals(4, counts.size());
        assertTrue(counts.containsKey(Dice.of(3)));
        assertTrue(counts.containsKey(Dice.of(4)));
        assertTrue(counts.containsKey(Dice.of(5)));
        assertTrue(counts.containsKey(Dice.of(2)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(3)));
        assertEquals(Long.valueOf(2), counts.get(Dice.of(4)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(5)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(2)));
    }

    @Test
    public void count_with_five_values(){
        Map<Dice, Long> counts = ScoreHelper.getFrequencyOfEachDiceValue(TestHelper.getDices(3,1,4,5,2));

        assertEquals(5, counts.size());
        assertTrue(counts.containsKey(Dice.of(3)));
        assertTrue(counts.containsKey(Dice.of(4)));
        assertTrue(counts.containsKey(Dice.of(5)));
        assertTrue(counts.containsKey(Dice.of(2)));
        assertTrue(counts.containsKey(Dice.of(1)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(3)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(4)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(5)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(2)));
        assertEquals(Long.valueOf(1), counts.get(Dice.of(1)));
    }
}
