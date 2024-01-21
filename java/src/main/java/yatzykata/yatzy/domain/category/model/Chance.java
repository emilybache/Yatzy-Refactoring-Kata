package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.roll.model.Roll;

public record Chance() implements Category {
  @Override
  public int calculateScore(Roll roll) {
    return roll.diceAsIntegers().stream().reduce(0, Integer::sum);
  }
}
