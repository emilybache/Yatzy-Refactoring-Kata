package com.wejden.kata.yatzy.game;

import org.junit.*;

import com.wejden.kata.yatzy.constants.YatzyConstants;
import com.wejden.kata.yatzy.model.DiceRoll;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = YatzyConstants.SMALL_STRAIGHT_SCORE.getValue();
        int actual = Yatzy.chance(new DiceRoll(2,3,4,5,1));
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance(new DiceRoll(3,3,4,5,1)));
    }

    @Test public void yatzy_scores_50() {
        int expected = YatzyConstants.YATZY_SCORE.getValue();
        int actual = Yatzy.yatzy(new DiceRoll(4,4,4,4,4));
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(new DiceRoll(6,6,6,6,6)));
        assertEquals(0, Yatzy.yatzy(new DiceRoll(6,6,6,6,3)));
    }

    @Test public void test_1s() {
        assertTrue(Yatzy.ones(new DiceRoll(1,2,3,4,5)) == 1);
        assertEquals(2, Yatzy.ones(new DiceRoll(1,2,1,4,5)));
        assertEquals(0, Yatzy.ones(new DiceRoll(6,2,2,4,5)));
        assertEquals(4, Yatzy.ones(new DiceRoll(1,2,1,1,1)));
    }

    @Test
    public void test_2s() {
        assertEquals(4, Yatzy.twos(new DiceRoll(1,2,3,2,6)));
        assertEquals(10, Yatzy.twos(new DiceRoll(2,2,2,2,2)));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.threes(new DiceRoll(1,2,3,2,3)));
        assertEquals(12, Yatzy.threes(new DiceRoll(2,3,3,3,3)));
    }

    @Test
    public void fours_test() 
    {
        DiceRoll roll1 = new DiceRoll(4, 4, 4, 5, 5);
        DiceRoll roll2 = new DiceRoll(4, 4, 5, 5, 5);
        DiceRoll roll3 = new DiceRoll(4, 5, 5, 5, 5);
        
        assertEquals(12, Yatzy.fours(roll1));
        assertEquals(8, Yatzy.fours(roll2));
        assertEquals(4, Yatzy.fours(roll3));
    }

    @Test
    public void fives() 
    {
        DiceRoll roll1 = new DiceRoll(4, 4, 4, 5, 5);
        DiceRoll roll2 = new DiceRoll(4, 4, 5, 5, 5);
        DiceRoll roll3 = new DiceRoll(4, 5, 5, 5, 5);
        
        assertEquals(10, Yatzy.fives(roll1));
        assertEquals(15, Yatzy.fives(roll2));
        assertEquals(20, Yatzy.fives(roll3));
    }

    @Test
    public void sixes_test() 
    {
        DiceRoll roll1 = new DiceRoll(4, 4, 4, 5, 5);
        DiceRoll roll2 = new DiceRoll(4, 4, 6, 5, 5);
        DiceRoll roll3 = new DiceRoll(6, 5, 6, 6, 5);
        
        assertEquals(0, Yatzy.sixes(roll1));
        assertEquals(6, Yatzy.sixes(roll2));
        assertEquals(18, Yatzy.sixes(roll3));
    }

    @Test
    public void one_pair() 
    {
        DiceRoll roll1 = new DiceRoll(3, 4, 3, 5, 6);
        DiceRoll roll2 = new DiceRoll(5, 3, 3, 3, 5);
        DiceRoll roll3 = new DiceRoll(5, 3, 6, 6, 5);
        
        assertEquals(6, Yatzy.score_pair(roll1));
        assertEquals(10, Yatzy.score_pair(roll2));
        assertEquals(12, Yatzy.score_pair(roll3));
    }

    @Test
    public void two_Pair() 
    {
        DiceRoll roll1 = new DiceRoll(3, 3, 5, 4, 5);
        DiceRoll roll2 = new DiceRoll(3, 3, 5, 5, 5);
        
        assertEquals(16, Yatzy.two_pair(roll1));
        assertEquals(16, Yatzy.two_pair(roll2));
    }

    @Test
    public void three_of_a_kind() 
    {
        DiceRoll roll1 = new DiceRoll(3, 3, 3, 4, 5);
        DiceRoll roll2 = new DiceRoll(5, 3, 5, 4, 5);
        DiceRoll roll3 = new DiceRoll(3, 3, 3, 3, 5);
        
        assertEquals(9, Yatzy.three_of_a_kind(roll1));
        assertEquals(15, Yatzy.three_of_a_kind(roll2));
        assertEquals(9, Yatzy.three_of_a_kind(roll3));
    }

    @Test
    public void four_of_a_knd() 
    {
        DiceRoll roll1 = new DiceRoll(3, 3, 3, 3, 5);
        DiceRoll roll2 = new DiceRoll(5, 5, 5, 4, 5);
        DiceRoll roll3 = new DiceRoll(3, 3, 3, 3, 3);
        
        assertEquals(12, Yatzy.four_of_a_kind(roll1));
        assertEquals(20, Yatzy.four_of_a_kind(roll2));
        assertEquals(9, Yatzy.three_of_a_kind(roll3));
    }

    @Test
    public void smallStraight() 
    {
        DiceRoll roll1 = new DiceRoll(1, 2, 3, 4, 5);
        DiceRoll roll2 = new DiceRoll(2, 3, 4, 5, 1);
        DiceRoll roll3 = new DiceRoll(1, 2, 2, 4, 5);
        
        assertEquals(15, Yatzy.smallStraight(roll1));
        assertEquals(15, Yatzy.smallStraight(roll2));
        assertEquals(0, Yatzy.smallStraight(roll3));
    }

    @Test
    public void largeStraight() 
    {
        DiceRoll roll1 = new DiceRoll(6, 2, 3, 4, 5);
        DiceRoll roll2 = new DiceRoll(2, 3, 4, 5, 6);
        DiceRoll roll3 = new DiceRoll(1, 2, 2, 4, 5);
        
        assertEquals(20, Yatzy.largeStraight(roll1));
        assertEquals(20, Yatzy.largeStraight(roll2));
        assertEquals(0, Yatzy.largeStraight(roll3));
    }

    @Test
    public void fullHouse() 
    {
        DiceRoll roll1 = new DiceRoll(6, 2, 2, 2, 6);
        DiceRoll roll2 = new DiceRoll(2, 3, 4, 5, 6);
        
        assertEquals(18, Yatzy.fullHouse(roll1));
        assertEquals(0, Yatzy.fullHouse(roll2));
    }
}
