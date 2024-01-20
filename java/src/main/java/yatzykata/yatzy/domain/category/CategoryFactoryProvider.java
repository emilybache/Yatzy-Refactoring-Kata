package yatzykata.yatzy.domain.category;

public class CategoryFactoryProvider {
  public CategoryFactory getCategoryFactory(CategoryType categoryType) {
    switch (categoryType) {
      case CHANCE -> {
        return new ChanceFactory();
      }
      case YATZY -> {
        return new YatzyFactory();
      }
      default -> {
        throw new IllegalArgumentException("Invalid category type: " + categoryType);
      }
    }
  }
}
