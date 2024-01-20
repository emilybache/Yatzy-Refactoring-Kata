package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.Pair;
import yatzykata.yatzy.domain.roll.model.Roll;

public class PairFactory implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new Pair(roll);
  }
}
