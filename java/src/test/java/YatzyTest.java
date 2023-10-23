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
    void chancesParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party chance = factory.createParty(Category.CHANCE);
        assertEquals(expected, chance.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 4, 4, 50", "6, 6, 6, 6, 6, 50", "6, 6, 6, 6, 3, 0" })
    void yatzysParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party yatzi = factory.createParty(Category.YATZI);
        assertEquals(expected, yatzi.calculateScore());
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
    void twosParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party twos = factory.createParty(Category.TWOS);
        assertEquals(expected, twos.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 2, 3, 6", "2, 3, 3, 3, 3, 12" })
    void threesParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party threes = factory.createParty(Category.THREES);
        assertEquals(expected, threes.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 12", "4, 4, 5, 5, 5, 8", "4, 5, 5, 5, 5, 4" })
    void foursParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party fours = factory.createParty(Category.FOURS);
        assertEquals(expected, fours.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 10", "4, 4, 5, 5, 5, 15", "4, 5, 5, 5, 5, 20" })
    void fivesParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party fives = factory.createParty(Category.FIVES);
        assertEquals(expected, fives.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "4, 4, 4, 5, 5, 0", "4, 4, 6, 5, 5, 6", "6, 5, 6, 6, 5, 18" })
    void sixesParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
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
    void pairsParty_succes(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party pair = factory.createParty(Category.PAIR);
        assertEquals(expected, pair.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "3, 3, 5, 4, 5, 16", "3, 3, 5, 5, 5, 16" })
    void twoPairsParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party twoPairs = factory.createParty(Category.TWO_PAIRS);
        assertEquals(expected, twoPairs.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "3, 3, 3, 4, 5, 9", "5, 3, 5, 4, 5, 15", "3, 3, 3, 3, 5, 9" })
    void threeOfAKindsParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party threeOfAKind = factory.createParty(Category.THREE_OF_A_KIND);
        assertEquals(expected, threeOfAKind.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "3, 3, 3, 3, 5, 12", "5, 5, 5, 4, 5, 20", "2, 2, 2, 2, 5, 8" })
    void fourOfAKindsParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party fourOfAKind = factory.createParty(Category.FOUR_OF_A_KIND);
        assertEquals(expected, fourOfAKind.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5,15", "2, 3, 4, 5, 1,15", "1, 2, 2, 4, 5,0" })
    void smallStraightsParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party smallStraight = factory.createParty(Category.SMALL_STRAIGHT);
        assertEquals(expected, smallStraight.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "6, 2, 3, 4, 5,20", "2, 3, 4, 5, 6,20", "1, 2, 2, 4, 5,0" })
    void largeStraightsParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party largeStraight = factory.createParty(Category.LARGE_STRAIGHT);
        assertEquals(expected, largeStraight.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "6, 2, 2, 2, 6,18", "2, 3, 4, 5, 6,0", "1, 1, 2, 2, 2,8", "2, 2, 3, 3, 4,0", "4, 4, 4, 4, 4,0" })
    void fullHousesParty_Success(int d1, int d2, int d3, int d4, int d5, int expected) {
        PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
        Party fullHouse = factory.createParty(Category.FULL_HOUSE);
        assertEquals(expected, fullHouse.calculateScore());
    }

    @ParameterizedTest
    @CsvSource({ "30, 4, 3, 5, 6, 6", "5, -3, 3, 3, 5, 10", "5, 3, 6, -6, 5, 12" })
    void pairsParty_InvalidDiceNumber_IllegalArgumentException(int d1, int d2, int d3, int d4, int d5, int expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
                    new Dice(d5));
            Party pair = factory.createParty(Category.PAIR);
            pair.calculateScore();
        });
        assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
    }

    @ParameterizedTest
    @CsvSource({ "3, 3, 5, 4, 50, 16", "3, -3, 5, 5, 5, 16" })
    void twoPairsParty_InvalidDiceNumber_IllegalArgumentException(int d1, int d2, int d3, int d4, int d5,
            int expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
                    new Dice(d5));
            Party twoPairs = factory.createParty(Category.TWO_PAIRS);
            twoPairs.calculateScore();
        });
        assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
    }

    @ParameterizedTest
    @CsvSource({ "3, 3, 3, 4, -5, 9", "5, 3, -5, 4, 5, 15", "3, 3, 30, 3, 5, 9" })
    void threeOfAKindsParty_InvalidDiceNumber_IllegalArgumentException(int d1, int d2, int d3, int d4, int d5,
            int expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
                    new Dice(d5));
            Party threeOfAKind = factory.createParty(Category.THREE_OF_A_KIND);
            threeOfAKind.calculateScore();
        });
        assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
    }

    @ParameterizedTest
    @CsvSource({ "30, 3, 3, 3, 5, 12", "5, 5, 5, 4, 50, 20", "-2, 2, 2, 2, 5, 8" })
    void fourOfAKindsParty_InvalidDiceNumber_IllegalArgumentException(int d1, int d2, int d3, int d4, int d5,
            int expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
                    new Dice(d5));
            Party fourOfAKind = factory.createParty(Category.FOUR_OF_A_KIND);
            fourOfAKind.calculateScore();
        });
        assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
    }

    @ParameterizedTest
    @CsvSource({ "1, 20, 3, 4, 5, 15", "2, 3, 4, 5, 10, 15", "1, 2, 2, 4, -5, 0" })
    void smallStraightsParty_InvalidDiceNumber_IllegalArgumentException(int d1, int d2, int d3, int d4, int d5,
            int expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
                    new Dice(d5));
            Party smallStraight = factory.createParty(Category.SMALL_STRAIGHT);
            smallStraight.calculateScore();
        });
        assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
    }

    @ParameterizedTest
    @CsvSource({ "60, 2, 3, 4, 5, 20", "2, -3, 4, 5, 6, 20", "1, 2, 2, 4, -5, 0" })
    void largeStraightsParty_InvalidDiceNumber_IllegalArgumentException(int d1, int d2, int d3, int d4, int d5,
            int expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
                    new Dice(d5));
            Party largeStraight = factory.createParty(Category.LARGE_STRAIGHT);
            largeStraight.calculateScore();
        });
        assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
    }

    @ParameterizedTest
    @CsvSource({ "60, 2, 2, 2, 6, 18", "2, -3, 4, 5, 6, 0", "1, 1, 20, 2, 2, 8", "2, -2, 3, 3, 4,0",
            "4, 4, 4, 4, -40, 0" })
    void fullHousesParty_InvalidDiceNumber_IllegalArgumentException(int d1, int d2, int d3, int d4, int d5,
            int expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
                    new Dice(d5));
            Party fullHouse = factory.createParty(Category.FULL_HOUSE);
            fullHouse.calculateScore();
        });
        assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
    }

}
