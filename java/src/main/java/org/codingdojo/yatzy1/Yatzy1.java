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
    public int getChanceScore() {
        return dices.stream().reduce(0, Integer::sum);
    }

    /**
     * @return 50 if all the dices are equals otherwise 0
     */
    public int yatzyScore() {
        return (dices.stream().distinct().count() == 1 ? YATZY_SCORE : 0);
    }

    /**
     * calculate the  sum of all the dices with the value sideNumber
     * @sideNumber the number of the side we are looking for
     * @return the  sum of all the dices with the value sideNumber
     */
    public int getScoreBySideFrequency(int sideNumber) {
        return YatzyHelper.findFrequency(sideNumber, dices) * sideNumber;
    }
    /**
     *  calculate the score the pairs
     * @return the sum the all pairs * 2
     */
    public int getScoreOfpair() {
        var numberPresentInPairs = YatzyHelper.getPairs(dices);
        if (numberPresentInPairs != null) {
            var pairValue = numberPresentInPairs.stream().sorted(Comparator.reverseOrder()).findFirst();
            if (pairValue.isPresent()) {
                return (pairValue.get()) * 2;
            }
            return 0;
        } else
            return 0;
    }
    /**
     *  calculate the score if there are two pairs
     * @return the sum the two pairs * 2
     */
    public int getScoreOfTwoPair() {
        var numberPresentInPairs = YatzyHelper.getPairs(dices);
        if (numberPresentInPairs.size() == 2) {
            return (numberPresentInPairs.stream()
                .mapToInt(Integer::intValue)
                .sum()) * 2;
        } else
            return 0;
    }
    /**
     * calculate score of the repeated dices n time
     * @param frequencyNumber how many the dice is repeated
     * @return sum of the repeated dices
     */
    public  int getScoreOfRepeatedSideByFrequencyNumber(int frequencyNumber)
    {
        return YatzyHelper.getRepeatedSideByFrequencyNumber(frequencyNumber, dices) * frequencyNumber;
    }

    /**
     *  the score if dices  contains 1,2,3,4,5
     * @return SMALL_STRAIGHT_SCORE if we have small straight otherwise 0
     */
    public int getSmallStraightScore() {
        if (YatzyHelper.isStraight(dices) && YatzyHelper.findFrequency(6, dices) == 0) {
            return SMALL_STRAIGHT_SCORE;
        }
        return 0;
    }
    /**
     *  the score if dices  contains 2,3,4,5,6
     * @return LARGE_STRAIGHT_SCORE if we have large straight otherwise 0
     */
    public int getLargeStraightScore() {
        if (YatzyHelper.isStraight(dices) && YatzyHelper.findFrequency(1, dices) == 0) {
            return LARGE_STRAIGHT_SCORE;
        }
        return 0;
    }
    /**
     *  calculate the score if there is a pair and three repeated dices
     * @return the score of a pair and three repeated dices
     */
    public int getFullHouseScore() {
        int repeatedTwice = YatzyHelper.getRepeatedSideByFrequencyNumber(2, dices);
        int repeatedThreeTimes = YatzyHelper.getRepeatedSideByFrequencyNumber(3, dices);
        if (repeatedTwice != 0 && repeatedThreeTimes != 0) {
            return repeatedThreeTimes * 3 + repeatedTwice * 2;
        }
        return 0;
    }
}



