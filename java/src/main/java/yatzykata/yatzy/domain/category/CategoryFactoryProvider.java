package yatzykata.yatzy.domain.category;

public class CategoryFactoryProvider {
  public CategoryFactory getCategoryFactory(CategoryType categoryType) {
    if (categoryType.equals(CategoryType.CHANCE)) {
      return new ChanceFactory();
    } else {
      throw new IllegalArgumentException("Invalid category type: " + categoryType);
    }
  }
}
