package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.FullHouse;

public record FullHouseFactory() implements CategoryFactory {
  @Override
  public Category createCategory() {
    return new FullHouse();
  }
}
