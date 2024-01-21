package yatzykata.yatzy;

import java.util.*;
import yatzykata.yatzy.domain.category.CategoryFactoryProvider;
import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.CategoryType;
import yatzykata.yatzy.domain.roll.model.Roll;

public final class YatzyGame {
  private Category category;
  private Roll roll;

  public YatzyGame() {}

  public YatzyGame roll(List<Integer> dice) {
    this.roll = Roll.from(dice);
    return this;
  }

  public YatzyGame placeOnCategory(CategoryType placedCategory) {
    this.category = CategoryFactoryProvider.getCategoryFactory(placedCategory).createCategory();
    return this;
  }

  public int score() {
    return category.calculateScore(roll);
  }
}
