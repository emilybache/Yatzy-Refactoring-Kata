package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Yatzy1Test {
    @Test
    public void testWhenIsYatzy() {
        int expected = 50;
        var yatzyScoreToTest = new Yatzy1(new int[]{4, 4, 4, 4, 4});
        assertEquals(expected, yatzyScoreToTest.yatzyScore());
    }

    @Test
    public void testWhenIsNotYatzy() {
        int expected = 0;
        var yatzyScoreToTest = new Yatzy1(new int[]{6, 6, 6, 6, 3});
        assertEquals(expected, yatzyScoreToTest.yatzyScore());
    }

    @Test
    public void testOnesScore() {
        var yatzyToTestOnesScore = new Yatzy1(new int[]{1, 2, 1, 4, 5});
        assertEquals(2, yatzyToTestOnesScore.getScoreBySideFrequency(1));
    }

    @Test
    public void testWithoutOnesScore() {
        var yatzyToTestOnesScore = new Yatzy1(new int[]{6, 2, 2, 4, 5});
        assertEquals(0, yatzyToTestOnesScore.getScoreBySideFrequency(1));
    }

    @Test
    public void testTwosScore() {
        var yatzyToTestTwosScore = new Yatzy1(new int[]{1, 2, 3, 2, 6});
        assertEquals(4, yatzyToTestTwosScore.getScoreBySideFrequency(2));
    }

    @Test
    public void testWithoutTwosScore() {
        var yatzyToTestTwosScore = new Yatzy1(new int[]{6, 8, 3, 4, 5});
        assertEquals(0, yatzyToTestTwosScore.getScoreBySideFrequency(2));
    }

    @Test
    public void testThreesScore() {
        var yatzyToTestThreesScore = new Yatzy1(new int[]{1, 2, 3, 2, 6});
        assertEquals(3, yatzyToTestThreesScore.getScoreBySideFrequency(3));
    }

    @Test
    public void testWithoutThreesScore() {
        var yatzyToTestThreesScore = new Yatzy1(new int[]{1, 2, 4, 2, 6});
        assertEquals(0, yatzyToTestThreesScore.getScoreBySideFrequency(3));
    }

    @Test
    public void testFoursScore() {
        var yatzyToTestThreesScore = new Yatzy1(new int[]{4, 4, 3, 2, 4});
        assertEquals(12, yatzyToTestThreesScore.getScoreBySideFrequency(4));
    }

    @Test
    public void testWithoutFoursScore() {
        var yatzyToTestFoursScore = new Yatzy1(new int[]{1, 2, 0, 2, 6});
        assertEquals(0, yatzyToTestFoursScore.getScoreBySideFrequency(4));
    }

    @Test
    public void testFivesScore() {
        var yatzyToTestFivesScore = new Yatzy1(new int[]{4, 5, 3, 5, 5});
        assertEquals(15, yatzyToTestFivesScore.getScoreBySideFrequency(5));
    }

    @Test
    public void testWithoutFivesScore() {
        var yatzyToTestFivesScore = new Yatzy1(new int[]{1, 2, 0, 2, 6});
        assertEquals(0, yatzyToTestFivesScore.getScoreBySideFrequency(5));
    }

    @Test
    public void testSixScore() {
        var yatzyToTestSixScore = new Yatzy1(new int[]{6, 5, 6, 6, 5});
        assertEquals(18, yatzyToTestSixScore.getScoreBySideFrequency(6));
    }

    @Test
    public void testWithoutSixScore() {
        var yatzyToTestSixScore = new Yatzy1(new int[]{4, 4, 4, 5, 5});
        assertEquals(0, yatzyToTestSixScore.getScoreBySideFrequency(6));
    }

    @Test
    public void chanceScoresTest() {
        int expected = 15;
        var yatzyToTestChance = new Yatzy1(new int[]{2, 3, 4, 5, 1});
        int actual = yatzyToTestChance.getChanceScore();
        assertEquals(expected, actual);
    }

    @Test
    public void chanceScoresTestSecond() {
        int expected = 16;
        var yatzyToTestChance = new Yatzy1(new int[]{3, 3, 4, 5, 1});
        int actual = yatzyToTestChance.getChanceScore();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetpairs() {
        var yatzyToTestPairScore = new Yatzy1(new int[]{3, 4, 3, 5, 6});
        var yatzyToTestOtherPairScore = new Yatzy1(new int[]{5, 3, 3, 3, 5});
        assertEquals(6, yatzyToTestPairScore.getScoreOfpair());
        assertEquals(10, yatzyToTestOtherPairScore.getScoreOfpair());
    }

    @Test
    public void tetsTwoPair() {
        var yatzyToTestPairScore = new Yatzy1(new int[]{3, 3, 5, 4, 5});
        var yatzyToTestOtherPairScore = new Yatzy1(new int[]{3, 3, 5, 4, 5});
        assertEquals(16, yatzyToTestPairScore.getScoreOfTwoPair());
        assertEquals(16, yatzyToTestOtherPairScore.getScoreOfTwoPair());
    }

    @Test
    public void testGetScoreOfThreeRepeatedSide() {
        var yatzyToTestScoreOfThreeRepeatedSide = new Yatzy1(new int[]{3, 3, 3, 4, 5});
        assertEquals(9, yatzyToTestScoreOfThreeRepeatedSide.getScoreOfRepeatedSideByFrequencyNumber(3));
    }

    @Test
    public void testGetScoreOfThreeRepeatedFiveSide() {
        var yatzyToTestScoreOfThreeRepeatedSide = new Yatzy1(new int[]{5, 3, 5, 4, 5});
        assertEquals(15, yatzyToTestScoreOfThreeRepeatedSide.getScoreOfRepeatedSideByFrequencyNumber(3));
    }

    @Test
    public void testGetScoreOfThreeWithManyRepeatedValue() {
        var yatzyToTestScoreOfThreeRepeatedSide = new Yatzy1(new int[]{3, 3, 3, 3, 3});
        assertEquals(9, yatzyToTestScoreOfThreeRepeatedSide.getScoreOfRepeatedSideByFrequencyNumber(3));
    }

    @Test
    public void testGetScoreOfFourRepeatedSide() {
        var yatzyToTestScoreOfFourRepeatedSide = new Yatzy1(new int[]{3, 2, 2, 2, 2});
        assertEquals(8, yatzyToTestScoreOfFourRepeatedSide.getScoreOfRepeatedSideByFrequencyNumber(4));
    }

    @Test
    public void testGetScoreOfFourWithManyRepeatedValue() {
        var yatzyToTestScoreOfFourRepeatedSide = new Yatzy1(new int[]{3, 3, 3, 3, 3});
        assertEquals(12, yatzyToTestScoreOfFourRepeatedSide.getScoreOfRepeatedSideByFrequencyNumber(4));
    }

    @Test
    public void testWhenIsSmallStraight() {
        var yatzyToTestSmallStraight = new Yatzy1(new int[]{1, 2, 3, 4, 5});
        assertEquals(15, yatzyToTestSmallStraight.getSmallStraightScore());
    }

    @Test
    public void testWhenIsNotSmallStraight() {
        var yatzyToTestSmallStraight = new Yatzy1(new int[]{1, 2, 2, 4, 5});
        assertEquals(0, yatzyToTestSmallStraight.getSmallStraightScore());
    }

    @Test
    public void testWhenIsLargeStraight() {
        var yatzyToTestLargeStraight = new Yatzy1(new int[]{6, 2, 3, 4, 5});
        assertEquals(20, yatzyToTestLargeStraight.getLargeStraightScore());
    }

    @Test
    public void testWhenIsNotLargetraight() {
        var yatzyToTestLargeStraight = new Yatzy1(new int[]{1, 2, 2, 4, 5});
        assertEquals(0, yatzyToTestLargeStraight.getLargeStraightScore());
    }

    @Test
    public void testWhereIsFullHouse() {
        var yatzyToTestFullHouse = new Yatzy1(new int[]{6, 2, 2, 2, 6});
        assertEquals(18, yatzyToTestFullHouse.getFullHouseScore());
    }

    @Test
    public void testWhereIsNotfullHouse() {
        var yatzyToTestFullHouse = new Yatzy1(new int[]{2, 3, 4, 5, 6});
        assertEquals(0, yatzyToTestFullHouse.getFullHouseScore());
    }
}
