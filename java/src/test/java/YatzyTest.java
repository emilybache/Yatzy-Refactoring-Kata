import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import yatzy.Category;
import yatzy.Dice;
import yatzy.Party;
import yatzy.factory.PartyFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void onesParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party ones = factory.createParty(Category.ONES);
        assertEquals(expected, ones.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 2, 6, 4", "2, 2, 2, 2, 2, 10" })
    void twosParty_success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party twos = factory.createParty(Category.TWOS);
        assertEquals(expected, twos.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 2, 3, 6", "2, 3, 3, 3, 3, 12" })
    void threesParty_success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party threes = factory.createParty(Category.THREES);
        assertEquals(expected, threes.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 12", "4, 4, 5, 5, 5, 8", "4, 5, 5, 5, 5, 4" })
    void foursParty_success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party fours = factory.createParty(Category.FOURS);
        assertEquals(expected, fours.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 10", "4, 4, 5, 5, 5, 15", "4, 5, 5, 5, 5, 20" })
    void fivesParty_success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party fives = factory.createParty(Category.FIVES);
        assertEquals(expected, fives.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 0", "4, 4, 6, 5, 5, 6", "6, 5, 6, 6, 5, 18" })
    void sixesParty_success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party sixes = factory.createParty(Category.SIXES);
        assertEquals(expected, sixes.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "10, 2, 3, 4, 5, 1", "1, 20, 1, 4, 5, 2", "6, 2, 2, -4, 5, 0", "1, 2, 1, 10, 1, 4" })
    void onesParty_InvalidDiceNumber_IllegalArgumentException(int d1, int d2, int d3, int d4, int d5, int expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
                    new Dice(d5));
            Party ones = factory.createParty(Category.ONES);
            ones.calculateScore();
        });
        assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
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
