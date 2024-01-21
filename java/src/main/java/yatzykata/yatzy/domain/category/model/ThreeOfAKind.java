package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.category.MatchingDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record ThreeOfAKind() implements Category {
  private static final int DIE_MATCH_THREE_TIMES = 3;

  @Override
  public int calculateScore(Roll roll) {
    return MatchingDiceHelper.getScoreForDiceThatMatchMultipleTimes(
        MatchingDiceHelper.getDiceByAtLeastANumberOfTimesADieIsFound(roll, DIE_MATCH_THREE_TIMES),
        DIE_MATCH_THREE_TIMES);
  }
}
