package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.ThreeOfAKind;
import yatzykata.yatzy.domain.roll.model.Roll;

public class ThreeOfAKindFactory implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new ThreeOfAKind(roll);
  }
}
