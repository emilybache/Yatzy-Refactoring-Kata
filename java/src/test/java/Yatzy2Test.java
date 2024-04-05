import org.junit.Test;
import yatzy1.Yatzy1;
import yatzy2.Yatzy2;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Yatzy2Test {
    Yatzy2 yatzy2 = new Yatzy2();

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, yatzy2.score(List.of(2,3,4,5,1), "chance"));
        assertEquals(16, yatzy2.score(List.of(3,3,4,5,1), "chance"));
    }

    @Test public void yatzy_scores_50() {
        assertEquals(50, yatzy2.score(List.of(4,4,4,4,4), "yatzy"));
        assertEquals(50, yatzy2.score(List.of(6,6,6,6,6), "yatzy"));
        assertEquals(0, yatzy2.score(List.of(6,6,6,6,3), "yatzy"));
    }

    @Test public void test_1s() {
        assertEquals(1, yatzy2.score(List.of(1,2,3,4,5), "ones"));
        assertEquals(2, yatzy2.score(List.of(1,2,1,4,5), "ones"));
        assertEquals(0, yatzy2.score(List.of(6,2,2,4,5), "ones"));
        assertEquals(4, yatzy2.score(List.of(1,2,1,1,1), "ones"));
    }

    @Test
    public void twos() {
        assertEquals(4, yatzy2.score(List.of(1,2,3,2,6), "twos"));
        assertEquals(10, yatzy2.score(List.of(2,2,2,2,2), "twos"));
    }

    @Test
    public void threes() {
        assertEquals(6, yatzy2.score(List.of(1,2,3,2,3), "threes"));
        assertEquals(12, yatzy2.score(List.of(2,3,3,3,3), "threes"));
    }

    @Test
    public void fours()
    {
        assertEquals(12, yatzy2.score(List.of(4,4,4,5,5), "fours"));
        assertEquals(8, yatzy2.score(List.of(4,4,5,5,5), "fours"));
        assertEquals(4, yatzy2.score(List.of(4,5,5,5,5), "fours"));
    }

    @Test
    public void fives() {
        assertEquals(10, yatzy2.score(List.of(4,4,4,5,5), "fives"));
        assertEquals(15, yatzy2.score(List.of(4,4,5,5,5), "fives"));
        assertEquals(20, yatzy2.score(List.of(4,5,5,5,5), "fives"));
    }
    @Test
    public void sixes() {
        assertEquals(0, yatzy2.score(List.of(4,4,4,5,5), "sixes"));
        assertEquals(6, yatzy2.score(List.of(4,4,6,5,5), "sixes"));
        assertEquals(18, yatzy2.score(List.of(6,5,6,6,5), "sixes"));
    }

    @Test
    public void pair() {
        assertEquals(6, yatzy2.score(List.of(3,4,3,5,6), "pair"));
        assertEquals(10, yatzy2.score(List.of(5,3,3,3,5), "pair"));
        assertEquals(12, yatzy2.score(List.of(5,3,6,6,5), "pair"));
    }

    @Test
    public void two_pair() {
        assertEquals(16, yatzy2.score(List.of(3,3,5,4,5), "twopairs"));
        assertEquals(16, yatzy2.score(List.of(3,3,5,5,5), "twopairs"));
    }

    @Test
    public void three_of_a_kind()
    {
        assertEquals(9, yatzy2.score(List.of(3,3,3,4,5), "threeofakind"));
        assertEquals(15, yatzy2.score(List.of(5,3,5,4,5), "threeofakind"));
        assertEquals(9, yatzy2.score(List.of(3,3,3,3,5), "threeofakind"));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, yatzy2.score(List.of(3,3,3,3,5), "fourofakind"));
        assertEquals(20, yatzy2.score(List.of(5,5,5,4,5), "fourofakind"));
        assertEquals(12, yatzy2.score(List.of(3,3,3,3,3), "fourofakind"));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, yatzy2.score(List.of(1,2,3,4,5), "smallstraight"));
        assertEquals(15, yatzy2.score(List.of(2,3,4,5,1), "smallstraight"));
        assertEquals(0, yatzy2.score(List.of(1,2,2,4,5), "smallstraight"));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, yatzy2.score(List.of(6,2,3,4,5), "largestraight"));
        assertEquals(20, yatzy2.score(List.of(2,3,4,5,6), "largestraight"));
        assertEquals(0, yatzy2.score(List.of(1,2,2,4,5), "largestraight"));
    }
    @Test
    public void fullHouse() {
        assertEquals(18, yatzy2.score(List.of(6,2,2,2,6), "fullhouse"));
        assertEquals(0, yatzy2.score(List.of(2,3,4,5,6), "fullhouse"));
    }

}
