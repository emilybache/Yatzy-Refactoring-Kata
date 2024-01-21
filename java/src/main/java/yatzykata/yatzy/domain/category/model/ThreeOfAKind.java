package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.category.RecurringDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record ThreeOfAKind() implements Category {
  private static final int A_DIE_IS_RECURRENT_THREE_TIMES = 3;

  @Override
  public int calculateScore(Roll roll) {
    return RecurringDiceHelper.getScoreForRecurringDice(
        RecurringDiceHelper.getDiceByExactRecurrenceOrMore(roll, A_DIE_IS_RECURRENT_THREE_TIMES),
        A_DIE_IS_RECURRENT_THREE_TIMES);
  }
}
