package yatzykata.yatzy.domain.category.model;

import java.util.function.Supplier;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.category.MatchingDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record FullHouse() implements Category {
  private static final int DIE_MATCH_TWO_TIMES = 2;
  private static final int DIE_MATCH_THREE_TIMES = 3;
  private static final int ONLY_ONE_MATCH_WAS_FOUND = 1;
  private static final int SCORE_OF_ZERO = 0;

  @Override
  public int calculateScore(Roll roll) {
    return getScoreForDiceMatchingWithASingleResult(roll, DIE_MATCH_TWO_TIMES)
        + getScoreForDiceMatchingWithASingleResult(roll, DIE_MATCH_THREE_TIMES);
  }

  private static Integer getScoreForDiceMatchingWithASingleResult(
      Roll roll, Integer numberOfTimesDieIsFound) {
    Supplier<Stream<Integer>> streamSupplierDiceFoundMultipleTimes =
        () ->
            MatchingDiceHelper.getDiceByExactlyANumberOfTimesADieIsFound(
                roll, numberOfTimesDieIsFound);

    if (streamSupplierDiceFoundMultipleTimes.get().count() == ONLY_ONE_MATCH_WAS_FOUND) {
      return MatchingDiceHelper.getScoreForDiceThatMatchMultipleTimes(
          streamSupplierDiceFoundMultipleTimes.get(), numberOfTimesDieIsFound);
    } else {
      return SCORE_OF_ZERO;
    }
  }
}
