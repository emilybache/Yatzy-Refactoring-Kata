package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.die.model.DieSide;
import yatzykata.yatzy.domain.roll.model.Roll;

public record RepeatedDie(Roll roll, DieSide dieSide) implements Category {
  @Override
  public int calculateScore() {
    return roll.diceAsIntegers().stream()
        .filter(die -> die.equals(dieSide.value))
        .reduce(0, Integer::sum);
  }
}
