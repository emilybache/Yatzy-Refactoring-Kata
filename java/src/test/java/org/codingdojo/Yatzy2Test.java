package org.codingdojo;

import org.codingdojo.yatzy2.Yatzy2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Yatzy2Test {
    Yatzy2 yatzy2 = new Yatzy2();

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, yatzy2.score(List.of(2,3,4,5,1), "CHANCE"));
        assertEquals(16, yatzy2.score(List.of(3,3,4,5,1), "CHANCE"));
    }

    @Test public void yatzy_scores_50() {
        assertEquals(50, yatzy2.score(List.of(4,4,4,4,4), "YATZY"));
        assertEquals(50, yatzy2.score(List.of(6,6,6,6,6), "YATZY"));
        assertEquals(0, yatzy2.score(List.of(6,6,6,6,3), "YATZY"));
    }

    @Test public void test_1s() {
        assertEquals(1, yatzy2.score(List.of(1,2,3,4,5), "ONES"));
        assertEquals(2, yatzy2.score(List.of(1,2,1,4,5), "ONES"));
        assertEquals(0, yatzy2.score(List.of(6,2,2,4,5), "ONES"));
        assertEquals(4, yatzy2.score(List.of(1,2,1,1,1), "ONES"));
    }

    @Test
    public void twos() {
        assertEquals(4, yatzy2.score(List.of(1,2,3,2,6), "TWOS"));
        assertEquals(10, yatzy2.score(List.of(2,2,2,2,2), "TWOS"));
    }

    @Test
    public void threes() {
        assertEquals(6, yatzy2.score(List.of(1,2,3,2,3), "THREES"));
        assertEquals(12, yatzy2.score(List.of(2,3,3,3,3), "THREES"));
    }

    @Test
    public void fours()
    {
        assertEquals(12, yatzy2.score(List.of(4,4,4,5,5), "FOURS"));
        assertEquals(8, yatzy2.score(List.of(4,4,5,5,5), "FOURS"));
        assertEquals(4, yatzy2.score(List.of(4,5,5,5,5), "FOURS"));
    }

    @Test
    public void fives() {
        assertEquals(10, yatzy2.score(List.of(4,4,4,5,5), "FIVES"));
        assertEquals(15, yatzy2.score(List.of(4,4,5,5,5), "FIVES"));
        assertEquals(20, yatzy2.score(List.of(4,5,5,5,5), "FIVES"));
    }
    @Test
    public void sixes() {
        assertEquals(0, yatzy2.score(List.of(4,4,4,5,5), "SIXES"));
        assertEquals(6, yatzy2.score(List.of(4,4,6,5,5), "SIXES"));
        assertEquals(18, yatzy2.score(List.of(6,5,6,6,5), "SIXES"));
    }

    @Test
    public void pair() {
        assertEquals(6, yatzy2.score(List.of(3,4,3,5,6), "PAIR"));
        assertEquals(10, yatzy2.score(List.of(5,3,3,3,5), "PAIR"));
        assertEquals(12, yatzy2.score(List.of(5,3,6,6,5), "PAIR"));
    }

    @Test
    public void two_pair() {
        assertEquals(16, yatzy2.score(List.of(3,3,5,4,5), "TWO_PAIRS"));
        assertEquals(16, yatzy2.score(List.of(3,3,5,5,5), "TWO_PAIRS"));
    }

    @Test
    public void three_of_a_kind()
    {
        assertEquals(9, yatzy2.score(List.of(3,3,3,4,5), "THREE_OF_A_KIND"));
        assertEquals(15, yatzy2.score(List.of(5,3,5,4,5), "THREE_OF_A_KIND"));
        assertEquals(9, yatzy2.score(List.of(3,3,3,3,5), "THREE_OF_A_KIND"));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, yatzy2.score(List.of(3,3,3,3,5), "FOUR_OF_A_KIND"));
        assertEquals(20, yatzy2.score(List.of(5,5,5,4,5), "FOUR_OF_A_KIND"));
        assertEquals(12, yatzy2.score(List.of(3,3,3,3,3), "FOUR_OF_A_KIND"));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, yatzy2.score(List.of(1,2,3,4,5), "SMALL_STRAIGHT"));
        assertEquals(15, yatzy2.score(List.of(2,3,4,5,1), "SMALL_STRAIGHT"));
        assertEquals(0, yatzy2.score(List.of(1,2,2,4,5), "SMALL_STRAIGHT"));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, yatzy2.score(List.of(6,2,3,4,5), "LARGE_STRAIGHT"));
        assertEquals(20, yatzy2.score(List.of(2,3,4,5,6), "LARGE_STRAIGHT"));
        assertEquals(0, yatzy2.score(List.of(1,2,2,4,5), "LARGE_STRAIGHT"));
    }
    @Test
    public void fullHouse() {
        assertEquals(18, yatzy2.score(List.of(6,2,2,2,6), "FULL_HOUSE"));
        assertEquals(0, yatzy2.score(List.of(2,3,4,5,6), "FULL_HOUSE"));
    }

}
