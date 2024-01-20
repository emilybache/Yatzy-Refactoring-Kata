package yatzykata.yatzy.domain.category.model;

import java.util.Comparator;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.category.MatchingDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record Pair(Roll roll) implements Category {
  private static final int DIE_MATCH_TWO_TIMES = 2;
  private static final int LIMIT_TO_ONE_PAIR = 1;

  @Override
  public int calculateScore() {
    Stream<Integer> diceFoundMultipleTimes =
        MatchingDiceHelper.getDiceByAtLeastANumberOfTimesADieIsFound(
                roll.dice(), DIE_MATCH_TWO_TIMES)
            .sorted(Comparator.reverseOrder())
            .limit(LIMIT_TO_ONE_PAIR);

    return MatchingDiceHelper.getScoreForDiceThatMatchMultipleTimes(
        diceFoundMultipleTimes, DIE_MATCH_TWO_TIMES);
  }
}
