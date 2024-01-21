package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.TwoPairs;

public record TwoPairsFactory() implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new TwoPairs();
  }
}
