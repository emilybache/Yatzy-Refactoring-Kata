package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Yatzy1Test {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yatzy1.chance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, Yatzy1.chance(3,3,4,5,1));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy1.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, Yatzy1.yatzy(6,6,6,6,6));
        assertEquals(0, Yatzy1.yatzy(6,6,6,6,3));
    }

    @Test public void test_1s() {
        assertTrue(Yatzy1.ones(1,2,3,4,5) == 1);
        assertEquals(2, Yatzy1.ones(1,2,1,4,5));
        assertEquals(0, Yatzy1.ones(6,2,2,4,5));
        assertEquals(4, Yatzy1.ones(1,2,1,1,1));
    }

    @Test
    public void test_2s() {
        assertEquals(4, Yatzy1.twos(1,2,3,2,6));
        assertEquals(10, Yatzy1.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy1.threes(1,2,3,2,3));
        assertEquals(12, Yatzy1.threes(2,3,3,3,3));
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12, new Yatzy1(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy1(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy1(4,5,5,5,5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy1(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy1(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy1(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy1(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy1(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy1(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy1().score_pair(3,4,3,5,6));
        assertEquals(10, new Yatzy1().score_pair(5,3,3,3,5));
        assertEquals(12, new Yatzy1().score_pair(5,3,6,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy1.two_pair(3,3,5,4,5));
        assertEquals(16, Yatzy1.two_pair(3,3,5,5,5));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy1.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, Yatzy1.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, Yatzy1.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy1.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, Yatzy1.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, Yatzy1.three_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy1.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy1.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy1.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy1.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy1.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy1.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy1.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy1.fullHouse(2,3,4,5,6));
    }
}
