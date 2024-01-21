package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.Straight;
import yatzykata.yatzy.domain.category.model.StraightType;

public record StraightFactory(StraightType straightType) implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new Straight(straightType);
  }
}
