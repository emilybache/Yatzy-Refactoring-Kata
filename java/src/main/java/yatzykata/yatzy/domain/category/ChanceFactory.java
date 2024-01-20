package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.Chance;
import yatzykata.yatzy.domain.roll.model.Roll;

public class ChanceFactory implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new Chance(roll);
  }
}
