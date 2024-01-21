package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.ThreeOfAKind;

public record ThreeOfAKindFactory() implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new ThreeOfAKind();
  }
}
