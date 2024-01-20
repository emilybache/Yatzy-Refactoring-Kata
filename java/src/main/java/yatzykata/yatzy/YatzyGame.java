package yatzykata.yatzy;

import java.util.*;
import yatzykata.yatzy.domain.category.CategoryFactoryProvider;
import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.CategoryType;
import yatzykata.yatzy.domain.roll.model.Roll;

public class YatzyGame {
  private final Category category;

  public YatzyGame(List<Integer> rolledDice, CategoryType placedCategory) {
    CategoryFactoryProvider categoryFactoryProvider = new CategoryFactoryProvider();
    this.category =
        categoryFactoryProvider
            .getCategoryFactory(placedCategory)
            .createCategory(Roll.from(rolledDice));
  }

  public int score() {
    return category.calculateScore();
  }
}
