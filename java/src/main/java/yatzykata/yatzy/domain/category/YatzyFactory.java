package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.Yatzy;
import yatzykata.yatzy.domain.roll.model.Roll;

public class YatzyFactory implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new Yatzy(roll);
  }
}
