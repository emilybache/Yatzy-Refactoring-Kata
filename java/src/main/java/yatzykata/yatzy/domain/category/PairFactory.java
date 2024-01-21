package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.Pair;

public record PairFactory() implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new Pair();
  }
}
