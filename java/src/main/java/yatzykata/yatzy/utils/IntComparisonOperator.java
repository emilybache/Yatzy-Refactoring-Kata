package yatzykata.yatzy.utils;

public enum IntComparisonOperator {
  EQUAL((a, b) -> a == b),
  GREATER_THAN_OR_EQUAL((a, b) -> a >= b);

  private final IntComparator comparator;

  IntComparisonOperator(IntComparator comparator) {
    this.comparator = comparator;
  }

  public boolean compare(int a, int b) {
    return comparator.compare(a, b);
  }
}

interface IntComparator {
  boolean compare(int a, int b);
}
