package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.FourOfAKind;
import yatzykata.yatzy.domain.roll.model.Roll;

public class FourOfAKindFactory implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new FourOfAKind(roll);
  }
}
