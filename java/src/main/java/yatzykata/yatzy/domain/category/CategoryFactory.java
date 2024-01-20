package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.roll.model.Roll;

public interface CategoryFactory {
  Category createCategory(Roll roll);
}
