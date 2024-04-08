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
        Dice d1 = new Dice(1, 1, 3, 3, 6);
        Dice d2 = new Dice(4, 5, 5, 6, 1);

        int actual1 = yatzy.chance(d1);
        int actual2 = yatzy.chance(d2);

        int expected1 = 14;
        int expected2 = 21;

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    void yatzy_should_return_50_if_all_dice_have_the_same_number() {
        Dice d1 = new Dice(1, 1, 1, 1, 1);
        Dice d2 = new Dice(2, 2, 2, 2, 2);
        Dice d3 = new Dice(3, 3, 3, 3, 3);
        Dice d4 = new Dice(4, 4, 4, 4, 4);
        Dice d5 = new Dice(5, 5, 5, 5, 5);
        Dice d6 = new Dice(6, 6, 6, 6, 6);

        int actual1 = yatzy.yatzy(d1);
        int actual2 = yatzy.yatzy(d2);
        int actual3 = yatzy.yatzy(d3);
        int actual4 = yatzy.yatzy(d4);
        int actual5 = yatzy.yatzy(d5);
        int actual6 = yatzy.yatzy(d6);

        int expected = 50;
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
        assertEquals(expected, actual4);
        assertEquals(expected, actual5);
        assertEquals(expected, actual6);
    }

    @Test
    void yatzy_should_return_0_if_one_or_more_dice_have_different_numbers() {
        Dice d1 = new Dice(1, 2, 3, 4, 5);
        int actual1 = yatzy.yatzy(d1);
        int expected = 0;
        assertEquals(expected, actual1);

    }

    @Test
    void ones_should_return_sum_of_ones() {
        Dice dice0 = new Dice(2, 2, 3, 4, 5);
        Dice dice1 = new Dice(4, 5, 5, 6, 1);
        Dice dice2 = new Dice(1, 1, 5, 5, 5);
        Dice dice3 = new Dice(1, 1, 1, 6, 6);
        Dice dice4 = new Dice(1, 1, 1, 1, 6);
        Dice dice5 = new Dice(1, 1, 1, 1, 1);

        int actual0 = yatzy.ones(dice0);
        int actual1 = yatzy.ones(dice1);
        int actual2 = yatzy.ones(dice2);
        int actual3 = yatzy.ones(dice3);
        int actual4 = yatzy.ones(dice4);
        int actual5 = yatzy.ones(dice5);

        assertEquals(0, actual0);
        assertEquals(1, actual1);
        assertEquals(2, actual2);
        assertEquals(3, actual3);
        assertEquals(4, actual4);
        assertEquals(5, actual5);
    }

    @Test
    void twos_should_return_sum_of_twos() {
        Dice dice0 = new Dice(1, 1, 3, 4, 5);
        Dice dice1 = new Dice(4, 2, 5, 6, 1);
        Dice dice2 = new Dice(2, 2, 5, 5, 5);
        Dice dice3 = new Dice(2, 2, 2, 6, 6);
        Dice dice4 = new Dice(2, 2, 2, 2, 6);
        Dice dice5 = new Dice(2, 2, 2, 2, 2);

        int actual0 = yatzy.twos(dice0);
        int actual1 = yatzy.twos(dice1);
        int actual2 = yatzy.twos(dice2);
        int actual3 = yatzy.twos(dice3);
        int actual4 = yatzy.twos(dice4);
        int actual5 = yatzy.twos(dice5);

        assertEquals(0, actual0);
        assertEquals(1, actual1);
        assertEquals(2, actual2);
        assertEquals(3, actual3);
        assertEquals(4, actual4);
        assertEquals(5, actual5);
    }

    @Test
    void threes_should_return_sum_of_threes() {
        Dice dice0 = new Dice(1, 1, 2, 4, 5);
        Dice dice1 = new Dice(3, 2, 5, 6, 1);
        Dice dice2 = new Dice(3, 3, 5, 5, 5);
        Dice dice3 = new Dice(3, 3, 3, 6, 6);
        Dice dice4 = new Dice(3, 3, 3, 3, 6);
        Dice dice5 = new Dice(3, 3, 3, 3, 3);

        int actual0 = yatzy.threes(dice0);
        int actual1 = yatzy.threes(dice1);
        int actual2 = yatzy.threes(dice2);
        int actual3 = yatzy.threes(dice3);
        int actual4 = yatzy.threes(dice4);
        int actual5 = yatzy.threes(dice5);

        assertEquals(0, actual0);
        assertEquals(1, actual1);
        assertEquals(2, actual2);
        assertEquals(3, actual3);
        assertEquals(4, actual4);
        assertEquals(5, actual5);
    }

    @Test
    void fours_should_return_sum_of_fours() {
        Dice dice0 = new Dice(1, 1, 3, 2, 5);
        Dice dice1 = new Dice(4, 2, 5, 6, 1);
        Dice dice2 = new Dice(2, 2, 4, 4, 5);
        Dice dice3 = new Dice(4, 4, 4, 6, 6);
        Dice dice4 = new Dice(4, 4, 4, 4, 6);
        Dice dice5 = new Dice(4, 4, 4, 4, 4);

        int actual0 = yatzy.fours(dice0);
        int actual1 = yatzy.fours(dice1);
        int actual2 = yatzy.fours(dice2);
        int actual3 = yatzy.fours(dice3);
        int actual4 = yatzy.fours(dice4);
        int actual5 = yatzy.fours(dice5);

        assertEquals(0, actual0);
        assertEquals(1, actual1);
        assertEquals(2, actual2);
        assertEquals(3, actual3);
        assertEquals(4, actual4);
        assertEquals(5, actual5);
    }

    @Test
    void fives_should_return_sum_of_fives() {
        Dice dice0 = new Dice(1, 1, 3, 4, 2);
        Dice dice1 = new Dice(4, 2, 5, 6, 1);
        Dice dice2 = new Dice(2, 2, 4, 5, 5);
        Dice dice3 = new Dice(5, 5, 5, 6, 6);
        Dice dice4 = new Dice(5, 5, 5, 5, 6);
        Dice dice5 = new Dice(5, 5, 5, 5, 5);

        int actual0 = yatzy.fives(dice0);
        int actual1 = yatzy.fives(dice1);
        int actual2 = yatzy.fives(dice2);
        int actual3 = yatzy.fives(dice3);
        int actual4 = yatzy.fives(dice4);
        int actual5 = yatzy.fives(dice5);

        assertEquals(0, actual0);
        assertEquals(1, actual1);
        assertEquals(2, actual2);
        assertEquals(3, actual3);
        assertEquals(4, actual4);
        assertEquals(5, actual5);
    }

    @Test
    void sixes_should_return_sum_of_sixes() {
        Dice dice0 = new Dice(1, 1, 3, 4, 5);
        Dice dice1 = new Dice(4, 2, 5, 6, 1);
        Dice dice2 = new Dice(6, 6, 5, 5, 5);
        Dice dice3 = new Dice(2, 2, 6, 6, 6);
        Dice dice4 = new Dice(2, 6, 6, 6, 6);
        Dice dice5 = new Dice(6, 6, 6, 6, 6);

        int actual0 = yatzy.sixs(dice0);
        int actual1 = yatzy.sixs(dice1);
        int actual2 = yatzy.sixs(dice2);
        int actual3 = yatzy.sixs(dice3);
        int actual4 = yatzy.sixs(dice4);
        int actual5 = yatzy.sixs(dice5);

        assertEquals(0, actual0);
        assertEquals(1, actual1);
        assertEquals(2, actual2);
        assertEquals(3, actual3);
        assertEquals(4, actual4);
        assertEquals(5, actual5);
    }

    @Test
    void pair_should_return_sum_of_two_highest_matching_dice_placed_on_pair() {
        Dice dice1 = new Dice(5, 1, 3, 5, 6);
        Dice dice2 = new Dice(6, 6, 3, 3, 1);
        Dice dice3 = new Dice(5, 3, 6, 6, 6);
        Dice dice4 = new Dice(1, 2, 3, 4, 5);

        int actual1 = yatzy.pair(dice1);
        int actual2 = yatzy.pair(dice2);
        int actual3 = yatzy.pair(dice3);
        int actual4 = yatzy.pair(dice4);

        int expected1 = 10;
        int expected2 = 12;
        int expected3 = 12;
        int expected4 = 0;

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    void two_pairs_should_return_sum_of_two_highest_matching_dice_placed_on_two_pairs() {
        Dice dice1 = new Dice(3, 3, 4, 4, 5);
        Dice dice2 = new Dice(2, 2, 5, 5, 5);

        int actual1 = yatzy.twoPairs(dice1);
        int actual2 = yatzy.twoPairs(dice2);

        int expected1 = 14;
        int expected2 = 14;

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    void three_of_kind_should_return_sum_of_two_highest_matching_dice_placed_on_three_pairs() {
        Dice dice1 = new Dice(3, 4, 4, 4, 5);
        Dice dice2 = new Dice(2, 2, 5, 5, 5);
        Dice dice3 = new Dice(1, 1, 1, 4, 5);

        int actual1 = yatzy.threeOfKind(dice1);
        int actual2 = yatzy.threeOfKind(dice2);
        int actual3 = yatzy.threeOfKind(dice3);

        int expected1 = 12;
        int expected2 = 15;
        int expected3 = 3;

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    void four_of_kind_should_return_sum_of_two_highest_matching_dice_placed_on_four_of_kind() {
        Dice dice1 = new Dice(4, 4, 4, 4, 5);
        Dice dice2 = new Dice(2, 5, 5, 5, 5);
        Dice dice3 = new Dice(1, 1, 1, 1, 5);

        int actual1 = yatzy.fourOfKind(dice1);
        int actual2 = yatzy.fourOfKind(dice2);
        int actual3 = yatzy.fourOfKind(dice3);

        int expected1 = 16;
        int expected2 = 20;
        int expected3 = 4;

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    void small_straight_should_return_sum_of_two_highest_matching_dice_placed_on_small_straight() {
        Dice dice1 = new Dice(1, 2, 3, 4, 5);
        Dice dice2 = new Dice(2, 5, 3, 4, 1);
        Dice dice3 = new Dice(1, 5, 2, 4, 5);

        int actual1 = yatzy.smallStraight(dice1);
        int actual2 = yatzy.smallStraight(dice2);
        int actual3 = yatzy.smallStraight(dice3);

        int expected15 = 15;
        int expected0 = 0;

        assertEquals(expected15, actual1);
        assertEquals(expected15, actual2);
        assertEquals(expected0, actual3);
    }

    @Test
    void large_straight_should_return_sum_of_two_highest_matching_dice_placed_on_large_straight() {
        Dice dice1 = new Dice(2, 6, 3, 4, 5);
        Dice dice2 = new Dice(2, 3, 4, 5, 6);
        Dice dice3 = new Dice(1, 5, 2, 4, 5);

        int actual1 = yatzy.largeStraight(dice1);
        int actual2 = yatzy.largeStraight(dice2);
        int actual3 = yatzy.largeStraight(dice3);

        int expected20 = 20;
        int expected0 = 0;

        assertEquals(expected20, actual1);
        assertEquals(expected20, actual2);
        assertEquals(expected0, actual3);
    }

    @Test
    void full_house_should_return_sum_of_two_highest_matching_dice_placed_on_full_house() {
        Dice dice1 = new Dice(1, 1, 2, 2, 2);
        Dice dice2 = new Dice(2, 2, 3, 3, 4);

        int actual1 = yatzy.fullHouse(dice1);
        int actual2 = yatzy.fullHouse(dice2);

        int expectedSum8 = 8;
        int expected0 = 0;

        assertEquals(expectedSum8, actual1);
        assertEquals(expected0, actual2);
    }
}
