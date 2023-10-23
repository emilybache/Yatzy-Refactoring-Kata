import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @ParameterizedTest
    @CsvSource({ "2, 3, 4, 5, 1, 15", "3, 3, 4, 5, 1, 16", "1, 1, 3, 3, 6, 14" })
    void chances(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.chance(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 4, 4, 50", "6, 6, 6, 6, 6, 50", "6, 6, 6, 6, 3, 0" })
    void yatzys(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.yatzy(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, 1", "1, 2, 1, 4, 5, 2", "6, 2, 2, 4, 5, 0", "1, 2, 1, 1, 1, 4" })
    void ones(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.ones(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 2, 6, 4", "2, 2, 2, 2, 2, 10" })
    void twos(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.twos(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 2, 3, 6", "2, 3, 3, 3, 3, 12" })
    void threes(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.threes(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 12", "4, 4, 5, 5, 5, 8", "4, 5, 5, 5, 5, 4" })
    void fours(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).fours());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 10", "4, 4, 5, 5, 5, 15", "4, 5, 5, 5, 5, 20" })
    void fives(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).fives());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 0", "4, 4, 6, 5, 5, 6", "6, 5, 6, 6, 5, 18" })
    void sixes(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).sixes());
    }

    @ParameterizedTest
    @CsvSource({ "3, 4, 3, 5, 6, 6", "5, 3, 3, 3, 5, 10", "5, 3, 6, 6, 5, 12" })
    void pairs(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.score_pair(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "3, 3, 5, 4, 5, 16", "3, 3, 5, 5, 5, 16" })
    void twoPairs(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.two_pair(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "3, 3, 3, 4, 5, 9", "5, 3, 5, 4, 5, 15", "3, 3, 3, 3, 5, 9" })
    void threeOfAKinds(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.three_of_a_kind(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "3, 3, 3, 3, 5, 12", "5, 5, 5, 4, 5, 20", "2, 2, 2, 2, 5, 8" })
    void fourOfAKinds(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.four_of_a_kind(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5,15", "2, 3, 4, 5, 1,15", "1, 2, 2, 4, 5,0" })
    void smallStraights(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.smallStraight(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "6, 2, 3, 4, 5,20", "2, 3, 4, 5, 6,20", "1, 2, 2, 4, 5,0" })
    void largeStraights(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.largeStraight(d1, d2, d3, d4, d5));
    }

    @ParameterizedTest
    @CsvSource({ "6, 2, 2, 2, 6,18", "2, 3, 4, 5, 6,0", "1, 1, 2, 2, 2,8", "2, 2, 3, 3, 4,0", "4, 4, 4, 4, 4,0" })
    void fullHouses(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy.fullHouse(d1, d2, d3, d4, d5));
    }

}
