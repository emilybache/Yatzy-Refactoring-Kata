package yatzykata.yatzy.domain.category.model;

import java.util.Comparator;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.category.RecurringDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record Pair() implements Category {
  private static final int A_DIE_IS_RECURRENT_TWO_TIMES = 2;
  private static final int LIMIT_TO_ONE_PAIR = 1;

  @Override
  public int calculateScore(Roll roll) {
    Stream<Integer> recurringDice =
        RecurringDiceHelper.getDiceByExactRecurrenceOrMore(roll, A_DIE_IS_RECURRENT_TWO_TIMES)
            .sorted(Comparator.reverseOrder())
            .limit(LIMIT_TO_ONE_PAIR);

    return RecurringDiceHelper.getScoreForRecurringDice(
        recurringDice, A_DIE_IS_RECURRENT_TWO_TIMES);
  }
}
