package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.die.model.DieSide;
import yatzykata.yatzy.domain.roll.model.Roll;

public record RepeatedDie(Roll roll, DieSide dieSide) implements Category {
  @Override
  public int calculateScore() {
    return roll.dice().stream()
        .filter(die -> die.equals(dieSide.getValue()))
        .reduce(0, Integer::sum);
  }
}
