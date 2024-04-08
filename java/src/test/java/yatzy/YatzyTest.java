package yatzy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {
    private Yatzy yatzy;
    @BeforeEach
    public void setUp() {
        yatzy = new Yatzy();
    }

    @Test
    public void chance_should_return_sum_of_all_dices() {
        Dice d1=new Dice(1,1,3,3,6);
        Dice d2=new Dice(4,5,5,6,1);

        int actual1 = yatzy.chance(d1);
        int actual2 = yatzy.chance(d2);

        int expected1 = 14;
        int expected2 = 21;

        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2);
    }

    @Test
    void yatzy_should_return_50_if_all_dice_have_the_same_number() {
        Dice d1=new Dice(1,1,1,1,1);
        Dice d2=new Dice(2,2,2,2,2);
        Dice d3=new Dice(3,3,3,3,3);
        Dice d4=new Dice(4,4,4,4,4);
        Dice d5=new Dice(5,5,5,5,5);
        Dice d6=new Dice(6,6,6,6,6);

        int actual1 = yatzy.yatzy(d1);
        int actual2 = yatzy.yatzy(d2);
        int actual3 = yatzy.yatzy(d3);
        int actual4 = yatzy.yatzy(d4);
        int actual5 = yatzy.yatzy(d5);
        int actual6 = yatzy.yatzy(d6);

        int expected = 50;
        assertEquals(expected,actual1);
        assertEquals(expected,actual2);
        assertEquals(expected,actual3);
        assertEquals(expected,actual4);
        assertEquals(expected,actual5);
        assertEquals(expected,actual6);
    }

    @Test
    void yatzy_should_return_0_if_one_or_more_dice_have_different_numbers() {
        Dice d1=new Dice(1,2,3,4,5);
        int actual1 = yatzy.yatzy(d1);
        int expected = 0;
        assertEquals(expected,actual1);

    }
    @Test
    void ones_should_return_sum_of_ones(){}
    @Test
    void twos_should_return_sum_of_twos(){}
    @Test
    void threes_should_return_sum_of_threes(){}
    @Test
    void fours_should_return_sum_of_fours(){}
    @Test
    void fives_should_return_sum_of_fives(){}
    @Test
    void sixes_should_return_sum_of_sixes(){}
    @Test
    void pair_should_return_sum_of_two_highest_matching_dice_placed_on_pair(){}
    @Test
    void two_pairs_should_return_sum_of_two_highest_matching_dice_placed_on_two_pairs(){}
    @Test
    void three_of_kind_should_return_sum_of_two_highest_matching_dice_placed_on_three_pairs(){}
    @Test
    void four_of_kind_should_return_sum_of_two_highest_matching_dice_placed_on_four_of_kind(){}
    @Test
    void small_straight_should_return_sum_of_two_highest_matching_dice_placed_on_small_straight(){}
    @Test
    void large_straight_should_return_sum_of_two_highest_matching_dice_placed_on_large_straight(){}
    @Test
    void full_house_should_return_sum_of_two_highest_matching_dice_placed_on_full_house(){}


























}
