package yatzykata.yatzy.domain.roll.model;

import java.util.List;
import yatzykata.yatzy.domain.die.model.DieSide;

public record Roll(List<DieSide> dice) {
  public static Roll from(List<Integer> diceAsIntegers) {
    List<DieSide> diceSides =
        diceAsIntegers.stream()
            .map(DieSide::fromInt)
            .map(
                maybeDieSide ->
                    maybeDieSide.orElseThrow(
                        () -> new IllegalArgumentException("Invalid dice: " + diceAsIntegers)))
            .toList();
    return new Roll(diceSides);
  }

  public List<Integer> diceAsIntegers() {
    return dice.stream().map(dieSide -> dieSide.value).toList();
  }
}
