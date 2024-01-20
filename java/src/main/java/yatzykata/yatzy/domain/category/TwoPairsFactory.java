package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.TwoPairs;
import yatzykata.yatzy.domain.roll.model.Roll;

public class TwoPairsFactory implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new TwoPairs(roll);
  }
}
