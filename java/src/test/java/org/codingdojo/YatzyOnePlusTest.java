package org.codingdojo;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.codingdojo.yatzy2.Yatzy2;
import org.codingdojo.yatzy3.Yatzy3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import org.lambda.functions.Function5;

import java.util.List;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class YatzyOnePlusTest {

    private static final Integer[] DICE_VALUES = {1, 2, 3, 4, 5, 6};

    private static List<Arguments> yatzyCalculators = List.of(
        arguments(named(Yatzy2.class.getSimpleName(), new Yatzy2())),
        arguments(named(Yatzy3.class.getSimpleName(), new Yatzy3()))
    );

    {
        Approvals.settings().allowMultipleVerifyCallsForThisClass();
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void chance_scores_sum_of_all_dice(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "CHANCE"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void yatzy_scores_50(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "YATZY"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void test_1s(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "ONES"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void twos(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "TWOS"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void threes(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "THREES"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void fours(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "FOURS"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void fives(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "FIVES"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }
    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void sixes(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "SIXES"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void pair(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "PAIR"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void two_pair(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "TWO_PAIRS"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void three_of_a_kind(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "THREE_OF_A_KIND"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void four_of_a_knd(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "FOUR_OF_A_KIND"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void smallStraight(YatzyCalculator calculator) {
        // Yatzy calculators have divergent results, so their expected results need to be distinct
        Options approvalsOptions = Approvals.NAMES.withParameters(calculator.getClass().getSimpleName());

        verifyAllCombinations(scoreOfCategory(calculator, "SMALL_STRAIGHT"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, approvalsOptions);
    }

    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void largeStraight(YatzyCalculator calculator) {
        // Yatzy calculators have divergent results, so their expected results need to be distinct
        Options approvalsOptions = Approvals.NAMES.withParameters(calculator.getClass().getSimpleName());

        verifyAllCombinations(scoreOfCategory(calculator, "LARGE_STRAIGHT"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, approvalsOptions);
    }
    @ParameterizedTest
    @FieldSource("yatzyCalculators")
    void fullHouse(YatzyCalculator calculator) {
        verifyAllCombinations(scoreOfCategory(calculator, "FULL_HOUSE"), DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES, DICE_VALUES);
    }

    private static Function5<Integer, Integer, Integer, Integer, Integer, Integer> scoreOfCategory(YatzyCalculator calculator, String category) {
        return (d1, d2, d3, d4, d5) -> calculator.score(List.of(d1, d2, d3, d4, d5), category);
    }

}
