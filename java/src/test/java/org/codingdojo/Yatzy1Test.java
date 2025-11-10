package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

class Yatzy1Test {

    private static final Integer[] DICE_VALUES = {1, 2, 3, 4, 5, 6};

    @Test
    void chance_scores_sum_of_all_dice() {
        verifyAllCombinations(Yatzy1::chance, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test void yatzy_scores_50() {
        verifyAllCombinations(Yatzy1::yatzy, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test void test_1s() {
        verifyAllCombinations(Yatzy1::ones, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void test_2s() {
        verifyAllCombinations(Yatzy1::twos, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void test_threes() {
        verifyAllCombinations(Yatzy1::threes, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void fours_test() {
        verifyAllCombinations(
            (d1, d2, d3, d4, d5) -> new Yatzy1(d1, d2, d3, d4, d5).fours(),
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES
        );
    }

    @Test
    void fives() {
        verifyAllCombinations(
            (d1, d2, d3, d4, d5) -> new Yatzy1(d1, d2, d3, d4, d5).fives(),
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES
        );
    }

    @Test
    void sixes_test() {
        verifyAllCombinations(
            (d1, d2, d3, d4, d5) -> new Yatzy1(d1, d2, d3, d4, d5).sixes(),
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES,
            DICE_VALUES
        );
    }

    @Test
    void one_pair() {
        verifyAllCombinations(new Yatzy1()::score_pair, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void two_Pair() {
        verifyAllCombinations(Yatzy1::two_pair, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void three_of_a_kind() 
    {
        verifyAllCombinations(Yatzy1::three_of_a_kind, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void four_of_a_knd() {
        verifyAllCombinations(Yatzy1::four_of_a_kind, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void smallStraight() {
        verifyAllCombinations(Yatzy1::smallStraight, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void largeStraight() {
        verifyAllCombinations(Yatzy1::largeStraight, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @Test
    void fullHouse() {
        verifyAllCombinations(Yatzy1::fullHouse, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }
}
