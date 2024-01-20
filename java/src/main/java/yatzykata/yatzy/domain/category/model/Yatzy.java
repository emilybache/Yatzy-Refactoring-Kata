package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.roll.model.Roll;

public record Yatzy(Roll roll) implements Category {
  private static final int SCORE_ALL_DICE_ARE_EQUAL = 50;
  private static final int SCORE_OF_ZERO = 0;
  private static final int NUMBER_OF_DIFFERENT_DICES = 1;

  @Override
  public int calculateScore() {
    return areAllDiceEqual() ? SCORE_ALL_DICE_ARE_EQUAL : SCORE_OF_ZERO;
  }

  private boolean areAllDiceEqual() {
    return roll.dice().stream().distinct().count() == NUMBER_OF_DIFFERENT_DICES;
  }
}
