package yatzykata.yatzy;

import static org.assertj.core.api.Assertions.assertThat;
import static yatzykata.yatzy.domain.category.model.CategoryType.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import yatzykata.yatzy.domain.category.model.CategoryType;

public class YatzyGameTest {
  @DisplayName("Verify score calculation")
  @ParameterizedTest(
      name = "[{index}] Rolled dice = {0}, Placed on category = {1}, Expected score = {2}")
  @MethodSource("testCases")
  public void score(List<Integer> rolledDice, CategoryType placedCategory, int expectedScore) {
    assertThat(new YatzyGame().roll(rolledDice).placeOnCategory(placedCategory).score())
        .isEqualTo(expectedScore);
  }

  private static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of(List.of(2, 3, 4, 5, 1), CHANCE, 15),
        Arguments.of(List.of(3, 3, 4, 5, 1), CHANCE, 16),
        Arguments.of(List.of(4, 4, 4, 4, 4), YATZY, 50),
        Arguments.of(List.of(6, 6, 6, 6, 6), YATZY, 50),
        Arguments.of(List.of(6, 6, 6, 6, 3), YATZY, 0),
        Arguments.of(List.of(1, 2, 3, 4, 5), ONES, 1),
        Arguments.of(List.of(1, 2, 1, 4, 5), ONES, 2),
        Arguments.of(List.of(6, 2, 2, 4, 5), ONES, 0),
        Arguments.of(List.of(1, 2, 1, 1, 1), ONES, 4),
        Arguments.of(List.of(1, 2, 3, 2, 6), TWOS, 4),
        Arguments.of(List.of(2, 2, 2, 2, 2), TWOS, 10),
        Arguments.of(List.of(1, 2, 3, 2, 3), THREES, 6),
        Arguments.of(List.of(2, 3, 3, 3, 3), THREES, 12),
        Arguments.of(List.of(4, 4, 4, 5, 5), FOURS, 12),
        Arguments.of(List.of(4, 4, 5, 5, 5), FOURS, 8),
        Arguments.of(List.of(4, 5, 5, 5, 5), FOURS, 4),
        Arguments.of(List.of(4, 4, 4, 5, 5), FIVES, 10),
        Arguments.of(List.of(4, 4, 5, 5, 5), FIVES, 15),
        Arguments.of(List.of(4, 5, 5, 5, 5), FIVES, 20),
        Arguments.of(List.of(4, 4, 4, 5, 5), SIXES, 0),
        Arguments.of(List.of(4, 4, 6, 5, 5), SIXES, 6),
        Arguments.of(List.of(6, 5, 6, 6, 5), SIXES, 18),
        Arguments.of(List.of(3, 4, 3, 5, 6), PAIR, 6),
        Arguments.of(List.of(5, 3, 3, 3, 5), PAIR, 10),
        Arguments.of(List.of(5, 3, 6, 6, 5), PAIR, 12),
        Arguments.of(List.of(3, 3, 5, 4, 5), TWO_PAIRS, 16),
        Arguments.of(List.of(3, 3, 5, 5, 5), TWO_PAIRS, 16),
        Arguments.of(List.of(3, 3, 4, 5, 6), TWO_PAIRS, 0),
        Arguments.of(List.of(3, 3, 3, 4, 5), THREE_OF_A_KIND, 9),
        Arguments.of(List.of(5, 3, 5, 4, 5), THREE_OF_A_KIND, 15),
        Arguments.of(List.of(3, 3, 3, 3, 5), THREE_OF_A_KIND, 9),
        Arguments.of(List.of(3, 3, 3, 3, 3), THREE_OF_A_KIND, 9),
        Arguments.of(List.of(3, 3, 3, 3, 5), FOUR_OF_A_KIND, 12),
        Arguments.of(List.of(5, 5, 5, 4, 5), FOUR_OF_A_KIND, 20),
        Arguments.of(List.of(1, 2, 3, 4, 5), SMALL_STRAIGHT, 15),
        Arguments.of(List.of(2, 3, 4, 5, 1), SMALL_STRAIGHT, 15),
        Arguments.of(List.of(1, 2, 2, 4, 5), SMALL_STRAIGHT, 0),
        Arguments.of(List.of(6, 2, 3, 4, 5), LARGE_STRAIGHT, 20),
        Arguments.of(List.of(2, 3, 4, 5, 6), LARGE_STRAIGHT, 20),
        Arguments.of(List.of(1, 2, 2, 4, 5), LARGE_STRAIGHT, 0),
        Arguments.of(List.of(6, 2, 2, 2, 6), FULL_HOUSE, 18),
        Arguments.of(List.of(2, 3, 4, 5, 6), FULL_HOUSE, 0),
        Arguments.of(List.of(2, 2, 3, 3, 4), FULL_HOUSE, 0),
        Arguments.of(List.of(4, 4, 4, 4, 4), FULL_HOUSE, 0));
  }
}
