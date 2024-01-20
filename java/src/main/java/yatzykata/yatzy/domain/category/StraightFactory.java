package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.Straight;
import yatzykata.yatzy.domain.category.model.StraightType;
import yatzykata.yatzy.domain.roll.model.Roll;

public record StraightFactory(StraightType straightType) implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new Straight(roll, straightType);
  }
}
