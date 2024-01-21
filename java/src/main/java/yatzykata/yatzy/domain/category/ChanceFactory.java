package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.Chance;

public record ChanceFactory() implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new Chance();
  }
}
