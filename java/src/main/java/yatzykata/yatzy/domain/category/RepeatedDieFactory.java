package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.RepeatedDie;
import yatzykata.yatzy.domain.die.model.DieSide;

public record RepeatedDieFactory(DieSide dieSide) implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new RepeatedDie(dieSide);
  }
}
