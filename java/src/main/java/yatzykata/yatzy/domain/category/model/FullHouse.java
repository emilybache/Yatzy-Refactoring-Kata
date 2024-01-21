package yatzykata.yatzy.domain.category.model;

import java.util.List;
import yatzykata.yatzy.domain.category.RecurringDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record FullHouse() implements Category {
  private static final int A_DIE_IS_RECURRENT_TWO_TIMES = 2;
  private static final int A_DIE_IS_RECURRENT_THREE_TIMES = 3;
  private static final int NUMBER_OF_RESULTS_EXPECTED_IS_ONE = 1;
  private static final int SCORE_OF_ZERO = 0;

  @Override
  public int calculateScore(Roll roll) {
    List<Integer> recurringDiceTwoTimes =
        RecurringDiceHelper.getDiceByExactRecurrence(roll, A_DIE_IS_RECURRENT_TWO_TIMES).toList();
    List<Integer> recurringDiceThreeTimes =
        RecurringDiceHelper.getDiceByExactRecurrence(roll, A_DIE_IS_RECURRENT_THREE_TIMES).toList();

    return getScoreForRecurringDiceWithExpectedNumberOfResults(
            recurringDiceTwoTimes, A_DIE_IS_RECURRENT_TWO_TIMES, NUMBER_OF_RESULTS_EXPECTED_IS_ONE)
        + getScoreForRecurringDiceWithExpectedNumberOfResults(
            recurringDiceThreeTimes,
            A_DIE_IS_RECURRENT_THREE_TIMES,
            NUMBER_OF_RESULTS_EXPECTED_IS_ONE);
  }

  public static Integer getScoreForRecurringDiceWithExpectedNumberOfResults(
      List<Integer> recurringDice, int expectedDieRecurrence, int expectedNumberOfResults) {
    if (recurringDice.size() == expectedNumberOfResults) {
      return RecurringDiceHelper.getScoreForRecurringDice(
          recurringDice.stream(), expectedDieRecurrence);
    } else {
      return SCORE_OF_ZERO;
    }
  }
}
