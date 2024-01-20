package yatzykata.yatzy.domain.category.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import yatzykata.yatzy.domain.die.model.DieSide;
import yatzykata.yatzy.domain.roll.model.Roll;

public record Straight(Roll roll, StraightType straightType) implements Category {
  private static final int SCORE_OF_ZERO = 0;

  @Override
  public int calculateScore() {
    return getScoreForStraight(roll.dice(), straightType);
  }

  private static Integer getScoreForStraight(List<Integer> dice, StraightType straightType) {
    List<Integer> dicesByStraightType = getDicesByStraightType(straightType);
    boolean allDiceMatchStraight = new HashSet<>(dice).containsAll(dicesByStraightType);
    if (allDiceMatchStraight) {
      return addAllDice(dice);
    } else {
      return SCORE_OF_ZERO;
    }
  }

  private static Integer addAllDice(List<Integer> dice) {
    return dice.stream().reduce(0, Integer::sum);
  }

  private static List<Integer> getDicesByStraightType(StraightType straightType) {
    if (straightType == StraightType.SMALL) {
      return getDicesInStraight(DieSide.ONE.getValue(), DieSide.FIVE.getValue());
    } else {
      return getDicesInStraight(DieSide.TWO.getValue(), DieSide.SIX.getValue());
    }
  }

  private static List<Integer> getDicesInStraight(int start, int end) {
    return IntStream.range(start, end + 1).boxed().collect(Collectors.toList());
  }
}
