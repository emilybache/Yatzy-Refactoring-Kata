package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.FourOfAKind;

public record FourOfAKindFactory() implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new FourOfAKind();
  }
}
