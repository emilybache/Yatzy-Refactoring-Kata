package yatzykata.yatzy.domain.category.model;

import java.util.function.Supplier;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.category.MatchingDiceHelper;
import yatzykata.yatzy.domain.roll.model.Roll;

public record TwoPairs(Roll roll) implements Category {
  private static final int DIE_MATCH_TWO_TIMES = 2;
  private static final int SCORE_OF_ZERO = 0;

  @Override
  public int calculateScore() {
    Supplier<Stream<Integer>> streamSupplierDiceFoundMultipleTimes =
        () ->
            MatchingDiceHelper.getDiceByAtLeastANumberOfTimesADieIsFound(
                roll.dice(), DIE_MATCH_TWO_TIMES);

    if (streamSupplierDiceFoundMultipleTimes.get().count() == 2) {
      return MatchingDiceHelper.getScoreForDiceThatMatchMultipleTimes(
          streamSupplierDiceFoundMultipleTimes.get(), DIE_MATCH_TWO_TIMES);
    } else {
      return SCORE_OF_ZERO;
    }
  }
}
