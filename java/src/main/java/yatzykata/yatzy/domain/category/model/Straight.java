package yatzykata.yatzy.domain.category.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import yatzykata.yatzy.domain.die.model.DieSide;
import yatzykata.yatzy.domain.roll.model.Roll;

public record Straight(StraightType straightType) implements Category {
  private static final int SCORE_OF_ZERO = 0;

  @Override
  public int calculateScore(Roll roll) {
    List<Integer> dice = roll.diceAsIntegers();
    List<Integer> diceByStraightType = getDiceByStraightType(straightType);
    if (doesDiceMatchStraight(dice, diceByStraightType)) {
      return getScoreFromDiceSum(dice);
    } else {
      return SCORE_OF_ZERO;
    }
  }

  private static boolean doesDiceMatchStraight(
      List<Integer> dice, List<Integer> dicesByStraightType) {
    return new HashSet<>(dice).containsAll(dicesByStraightType);
  }

  private static Integer getScoreFromDiceSum(List<Integer> dice) {
    return dice.stream().reduce(0, Integer::sum);
  }

  private static List<Integer> getDiceByStraightType(StraightType straightType) {
    return switch (straightType) {
      case SMALL -> getDicesInStraight(DieSide.ONE.value, DieSide.FIVE.value);
      case LARGE -> getDicesInStraight(DieSide.TWO.value, DieSide.SIX.value);
    };
  }

  private static List<Integer> getDicesInStraight(int start, int end) {
    return IntStream.range(start, end + 1).boxed().collect(Collectors.toList());
  }
}
