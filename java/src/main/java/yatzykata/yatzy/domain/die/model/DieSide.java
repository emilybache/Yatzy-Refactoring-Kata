package yatzykata.yatzy.domain.die.model;

import java.util.Arrays;
import java.util.Optional;

public enum DieSide {
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6);

  public final int value;

  DieSide(int value) {
    this.value = value;
  }

  public static Optional<DieSide> fromInt(int value) {
    return Arrays.stream(values()).filter(dieSide -> dieSide.value == value).findFirst();
  }
}
