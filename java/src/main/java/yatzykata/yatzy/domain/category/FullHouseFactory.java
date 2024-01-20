package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.FullHouse;
import yatzykata.yatzy.domain.roll.model.Roll;

public class FullHouseFactory implements CategoryFactory {
  @Override
  public Category createCategory(Roll roll) {
    return new FullHouse(roll);
  }
}
