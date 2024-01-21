package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.category.RecurringDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record FourOfAKind() implements Category {
  private static final int A_DIE_IS_RECURRENT_FOUR_TIMES = 4;

  @Override
  public int calculateScore(Roll roll) {
    return RecurringDiceHelper.getScoreForRecurringDice(
        RecurringDiceHelper.getDiceByExactRecurrenceOrMore(roll, A_DIE_IS_RECURRENT_FOUR_TIMES),
        A_DIE_IS_RECURRENT_FOUR_TIMES);
  }
}
