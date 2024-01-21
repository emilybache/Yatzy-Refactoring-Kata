package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.Yatzy;

public record YatzyFactory() implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new Yatzy();
  }
}
