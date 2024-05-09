package org.codingdojo.yatzy1;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@UtilityClass
public class YatzyHelper {
    /**
     *
     * @param number whose  frequency to detemined
     * @param diceValues
     * @return the frequency of th number in the diceValues
     */
    public static int findFrequency(int number, List<Integer> diceValues) {
        return diceValues != null ? Collections.frequency(diceValues, number) : 0;
    }

    /**
     *
     * @param frequencyNumber
     * @param diceValues
     * @return the value whose repeated n times (n = frequencyNumber)
     */
    public static int getRepeatedSideByFrequencyNumber(int frequencyNumber, List<Integer> diceValues) {
        return diceValues.stream()
            .sorted(Comparator.reverseOrder())
            .filter(side -> findFrequency(side, diceValues) >= frequencyNumber)
            .findFirst()
            .orElse(0);
    }

    /**
     *
     * @param diceValues
     * @return if the list is contains straight or not
     */
    public static boolean isStraight(List<Integer> diceValues) {
        int[] s = diceValues.stream().sorted().mapToInt(Integer::intValue).toArray();
        IntStream differences =
            IntStream.range(0, s.length - 1)
                .map(i -> s[i + 1] - s[i]).filter(f -> f != 1);
        return differences.count() == 0;
    }

    /**
     *
     * @param diceValues
     * @return the pairs of dices
     */
    public static Set<Integer> getPairs(List<Integer> diceValues) {
        Set<Integer> allPossiblePairs = new HashSet<>();
        diceValues.forEach(value -> {
            if (findFrequency(value.intValue(), diceValues) >= 2) {
                allPossiblePairs.add(value);
            }
        });
        return allPossiblePairs;
    }
}