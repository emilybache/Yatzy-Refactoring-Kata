package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.RepeatedDie;
import yatzykata.yatzy.domain.die.model.DieSide;
import yatzykata.yatzy.domain.roll.model.Roll;

public record RepeatedDieFactory(DieSide dieSide) implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new RepeatedDie(roll, dieSide);
  }
}
