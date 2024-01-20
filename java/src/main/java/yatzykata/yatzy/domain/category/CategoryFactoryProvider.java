package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.CategoryType;
import yatzykata.yatzy.domain.die.model.DieSide;

public class CategoryFactoryProvider {
  public CategoryFactory getCategoryFactory(CategoryType categoryType) {
    switch (categoryType) {
      case CHANCE -> {
        return new ChanceFactory();
      }
      case YATZY -> {
        return new YatzyFactory();
      }
      case ONES -> {
        return new RepeatedDieFactory(DieSide.ONE);
      }
      case TWOS -> {
        return new RepeatedDieFactory(DieSide.TWO);
      }
      case THREES -> {
        return new RepeatedDieFactory(DieSide.THREE);
      }
      case FOURS -> {
        return new RepeatedDieFactory(DieSide.FOUR);
      }
      case FIVES -> {
        return new RepeatedDieFactory(DieSide.FIVE);
      }
      case SIXES -> {
        return new RepeatedDieFactory(DieSide.SIX);
      }
      default -> {
        throw new IllegalArgumentException("Invalid category type: " + categoryType);
      }
    }
  }
}
