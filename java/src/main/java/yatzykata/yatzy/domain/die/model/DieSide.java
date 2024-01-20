package yatzykata.yatzy.domain.die.model;

public enum DieSide {
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6);

  private final int value;

  DieSide(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
