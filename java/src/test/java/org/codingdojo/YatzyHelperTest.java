package fr.bred.apicorptransfer.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YatzyHelperTest {
    @Test
    void findFrequency() {
        int expected = 3;
        var frequencyOfTwo = YatzyHelper.findFrequency(2, createYatzyDice(new int[]{2, 3, 2, 5, 2}));
        assertEquals(expected, frequencyOfTwo);
    }

    @Test
    void getRepeatedSideByFrequencyNumber() {
        int expected = 5;
        var repeatedSideTwice = YatzyHelper.getRepeatedSideByFrequencyNumber(2, createYatzyDice(new int[]{2, 5, 2, 5, 2}));
        assertEquals(expected, repeatedSideTwice);
    }

    @Test
    void isNotStraight() {
        var isStraight = YatzyHelper.isStraight(createYatzyDice(new int[]{2, 5, 2, 5, 2}));
        assertFalse(isStraight);
    }

    @Test
    void isStraight() {
        var isStraight = YatzyHelper.isStraight(createYatzyDice(new int[]{2, 3, 6, 5, 4}));
        assertTrue(isStraight);
    }

    @Test
    void getPairs() {
        var exceptedParis = new HashSet<>(createYatzyDice(new int[]{2, 5}));
        var resultOfPairs = YatzyHelper.getPairs(createYatzyDice(new int[]{2, 5, 2, 5, 2}));
        assertEquals(exceptedParis, resultOfPairs);
    }

    private List<Integer> createYatzyDice(int[] dices) {
        return Arrays.stream(dices).boxed().toList();
    }
}