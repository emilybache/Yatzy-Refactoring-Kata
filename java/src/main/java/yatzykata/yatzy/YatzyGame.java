package yatzykata.yatzy;

import java.util.*;
import java.util.stream.Collectors;
import yatzykata.yatzy.domain.category.CategoryFactoryProvider;
import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.CategoryType;
import yatzykata.yatzy.domain.roll.model.Roll;

public class YatzyGame {
  private final Category category;

  public YatzyGame(CategoryType categoryType, int... dice) {
    CategoryFactoryProvider categoryFactoryProvider = new CategoryFactoryProvider();
    Roll roll = new Roll(Arrays.stream(dice).boxed().collect(Collectors.toList()));
    this.category = categoryFactoryProvider.getCategoryFactory(categoryType).createCategory(roll);
  }

  public int score() {
    return category.calculateScore();
  }
}
