package org.codingdojo.yatzy1;

public class Yatzy1 {
    private static final int YATZY_SCORE = 50;
    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;
    private final List<Integer> dices;
    public Yatzy1(int[] dices) {
        this.dices = Arrays.stream(dices).boxed().toList();
    }

    /**
     * calculate the sum of all the dices
     * @return the sum of all the dices
     */
    public  int chance()
    {
        int total = 0;
        return total;
    }

    /**
     * @return 50 if all the dices are equals otherwise 0
     */
    public  int yatzyScore()
    {
        return 0;
    }

    /**
     * calculate the  sum of all the dices with the value sideNumber
     * @param the number of the side we are looking for
     * @return the  sum of all the dices with the value sideNumber
     */
    public int getScoreBySideFrequency(int sideNumber) {
        return 0;
    }

    /**
     *  calculate the score the pairs
     * @return the sum the all pairs * 2
     */
    public int getScoreOfPair()
    {
        return 0;
    }
    /**
     *  calculate the score if there are two pairs
     * @return the sum the two pairs * 2
     */
    public static int getScoreOfTowPair()
    {
        return 0;
    }

    /**
     * calculate score of the repeated dices n time
     * @param frenquencyNumber how many the dice is repeated
     * @return sum of the repeated dices
     */
    public static int getScoreOfRepeatedSideByFrequencyNumber(int frenquencyNumber)
    {
        return 0;
    }

    /**
     *  the score if dices  contains 1,2,3,4,5
     * @return SMALL_STRAIGHT_SCORE if we have small straight otherwise 0
     */
    public static int getLargeStraightScore()
    {
        return 0;
    }
    /**
     *  the score if dices  contains 2,3,4,5,6
     * @return LARGE_STRAIGHT_SCORE if we have large straight otherwise 0
     */
    public static int getLargeStraightScore()
    {
        return 0;
    }

    /**
     *  calculate the score if there is a pair and three repeated dices
     * @return the score of a pair and three repeated dices
     */
    public static int getFullHouseScore()
    {
        return 0;
    }
}



