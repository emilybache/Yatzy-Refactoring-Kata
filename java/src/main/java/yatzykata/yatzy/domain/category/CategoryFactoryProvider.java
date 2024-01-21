package yatzykata.yatzy.domain.category;

import yatzykata.yatzy.domain.category.model.CategoryType;
import yatzykata.yatzy.domain.category.model.StraightType;
import yatzykata.yatzy.domain.die.model.DieSide;

public record CategoryFactoryProvider() {
  public static CategoryFactory getCategoryFactory(CategoryType categoryType) {
    return switch (categoryType) {
      case CHANCE -> new ChanceFactory();
      case YATZY -> new YatzyFactory();
      case ONES -> new RepeatedDieFactory(DieSide.ONE);
      case TWOS -> new RepeatedDieFactory(DieSide.TWO);
      case THREES -> new RepeatedDieFactory(DieSide.THREE);
      case FOURS -> new RepeatedDieFactory(DieSide.FOUR);
      case FIVES -> new RepeatedDieFactory(DieSide.FIVE);
      case SIXES -> new RepeatedDieFactory(DieSide.SIX);
      case SMALL_STRAIGHT -> new StraightFactory(StraightType.SMALL);
      case LARGE_STRAIGHT -> new StraightFactory(StraightType.LARGE);
      case PAIR -> new PairFactory();
      case TWO_PAIRS -> new TwoPairsFactory();
      case THREE_OF_A_KIND -> new ThreeOfAKindFactory();
      case FOUR_OF_A_KIND -> new FourOfAKindFactory();
      case FULL_HOUSE -> new FullHouseFactory();
    };
  }
}
