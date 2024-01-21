package yatzykata.yatzy.domain.category.model;

import java.util.function.Supplier;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.category.RecurringDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record TwoPairs() implements Category {
  private static final int A_DIE_IS_RECURRENT_TWO_TIMES = 2;
  private static final int TWO_RESULTS_FOUND_FOR_RECURRENCE = 2;
  private static final int SCORE_OF_ZERO = 0;

  @Override
  public int calculateScore(Roll roll) {
    return getScoreForDiceByRecurrence(
        roll, A_DIE_IS_RECURRENT_TWO_TIMES, TWO_RESULTS_FOUND_FOR_RECURRENCE);
  }

  private static Integer getScoreForDiceByRecurrence(
      Roll roll, int expectedDieRecurrence, int expectedNumberOfResults) {
    Supplier<Stream<Integer>> streamSupplierForRecurringDice =
        () -> RecurringDiceHelper.getDiceByExactRecurrenceOrMore(roll, expectedDieRecurrence);

    if (doesNumberOfResultsCorrespondToExpected(
        streamSupplierForRecurringDice.get(), expectedNumberOfResults)) {
      return RecurringDiceHelper.getScoreForRecurringDice(
          streamSupplierForRecurringDice.get(), expectedDieRecurrence);
    } else {
      return SCORE_OF_ZERO;
    }
  }

  private static boolean doesNumberOfResultsCorrespondToExpected(
      Stream<Integer> dice, int expectedNumberOfResults) {
    return dice.count() == expectedNumberOfResults;
  }
}
