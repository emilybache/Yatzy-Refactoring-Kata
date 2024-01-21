package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.category.RecurringDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record TwoPairs() implements Category {
  private static final int A_DIE_IS_RECURRENT_TWO_TIMES = 2;
  private static final int NUMBER_OF_RESULTS_EXPECTED_IS_TWO = 2;
  private static final int SCORE_OF_ZERO = 0;

  @Override
  public int calculateScore(Roll roll) {
    var recurringDiceTwoTimes =
        RecurringDiceHelper.getDiceByExactRecurrenceOrMore(roll, A_DIE_IS_RECURRENT_TWO_TIMES)
            .toList();

    if (recurringDiceTwoTimes.size() == NUMBER_OF_RESULTS_EXPECTED_IS_TWO) {
      return RecurringDiceHelper.getScoreForRecurringDice(
          recurringDiceTwoTimes.stream(), A_DIE_IS_RECURRENT_TWO_TIMES);
    } else {
      return SCORE_OF_ZERO;
    }
  }
}
