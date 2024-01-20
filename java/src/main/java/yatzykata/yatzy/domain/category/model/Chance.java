package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.roll.model.Roll;

public record Chance(Roll roll) implements Category {
  @Override
  public int calculateScore() {
    return roll.dice().stream().reduce(0, Integer::sum);
  }
}
