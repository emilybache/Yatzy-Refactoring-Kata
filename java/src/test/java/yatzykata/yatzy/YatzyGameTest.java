package yatzykata.yatzy;

import static org.assertj.core.api.Assertions.assertThat;
import static yatzykata.yatzy.domain.category.model.CategoryType.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class YatzyGameTest {

  @Test
  public void scoreTheSumOfAllDice() {
    assertThat(new YatzyGame(List.of(2, 3, 4, 5, 1), CHANCE).score()).isEqualTo(15);
    assertThat(new YatzyGame(List.of(3, 3, 4, 5, 1), CHANCE).score()).isEqualTo(16);
  }

  @Test
  public void score50() {
    assertThat(new YatzyGame(List.of(4, 4, 4, 4, 4), YATZY).score()).isEqualTo(50);
    assertThat(new YatzyGame(List.of(6, 6, 6, 6, 6), YATZY).score()).isEqualTo(50);
    assertThat(new YatzyGame(List.of(6, 6, 6, 6, 3), YATZY).score()).isEqualTo(0);
  }

  @Test
  public void scoreSumOfOnes() {
    assertThat(new YatzyGame(List.of(1, 2, 3, 4, 5), ONES).score()).isEqualTo(1);
    assertThat(new YatzyGame(List.of(1, 2, 1, 4, 5), ONES).score()).isEqualTo(2);
    assertThat(new YatzyGame(List.of(6, 2, 2, 4, 5), ONES).score()).isEqualTo(0);
    assertThat(new YatzyGame(List.of(1, 2, 1, 1, 1), ONES).score()).isEqualTo(4);
  }

  @Test
  public void scoreSumOfTwos() {
    assertThat(new YatzyGame(List.of(1, 2, 3, 2, 6), TWOS).score()).isEqualTo(4);
    assertThat(new YatzyGame(List.of(2, 2, 2, 2, 2), TWOS).score()).isEqualTo(10);
  }

  @Test
  public void scoreSumOfThrees() {
    assertThat(new YatzyGame(List.of(1, 2, 3, 2, 3), THREES).score()).isEqualTo(6);
    assertThat(new YatzyGame(List.of(2, 3, 3, 3, 3), THREES).score()).isEqualTo(12);
  }

  @Test
  public void scoreSumOfFours() {
    assertThat(new YatzyGame(List.of(4, 4, 4, 5, 5), FOURS).score()).isEqualTo(12);
    assertThat(new YatzyGame(List.of(4, 4, 5, 5, 5), FOURS).score()).isEqualTo(8);
    assertThat(new YatzyGame(List.of(4, 5, 5, 5, 5), FOURS).score()).isEqualTo(4);
  }

  @Test
  public void scoreSumOfFives() {
    assertThat(new YatzyGame(List.of(4, 4, 4, 5, 5), FIVES).score()).isEqualTo(10);
    assertThat(new YatzyGame(List.of(4, 4, 5, 5, 5), FIVES).score()).isEqualTo(15);
    assertThat(new YatzyGame(List.of(4, 5, 5, 5, 5), FIVES).score()).isEqualTo(20);
  }

  @Test
  public void scoreSumOfSixes() {
    assertThat(new YatzyGame(List.of(4, 4, 4, 5, 5), SIXES).score()).isEqualTo(0);
    assertThat(new YatzyGame(List.of(4, 4, 6, 5, 5), SIXES).score()).isEqualTo(6);
    assertThat(new YatzyGame(List.of(6, 5, 6, 6, 5), SIXES).score()).isEqualTo(18);
  }

  @Test
  public void scoreSumOfOnePair() {
    assertThat(new YatzyGame(List.of(3, 4, 3, 5, 6), PAIR).score()).isEqualTo(6);
    assertThat(new YatzyGame(List.of(5, 3, 3, 3, 5), PAIR).score()).isEqualTo(10);
    assertThat(new YatzyGame(List.of(5, 3, 6, 6, 5), PAIR).score()).isEqualTo(12);
  }

  @Test
  public void scoreSumOfTwoPairs() {
    assertThat(new YatzyGame(List.of(3, 3, 5, 4, 5), TWO_PAIRS).score()).isEqualTo(16);
    assertThat(new YatzyGame(List.of(3, 3, 5, 5, 5), TWO_PAIRS).score()).isEqualTo(16);
    assertThat(new YatzyGame(List.of(3, 3, 4, 5, 6), TWO_PAIRS).score()).isEqualTo(0);
  }

  @Test
  public void scoreSumOfThreeOfAKind() {
    assertThat(new YatzyGame(List.of(3, 3, 3, 4, 5), THREE_OF_A_KIND).score()).isEqualTo(9);
    assertThat(new YatzyGame(List.of(5, 3, 5, 4, 5), THREE_OF_A_KIND).score()).isEqualTo(15);
    assertThat(new YatzyGame(List.of(3, 3, 3, 3, 5), THREE_OF_A_KIND).score()).isEqualTo(9);
    assertThat(new YatzyGame(List.of(3, 3, 3, 3, 3), THREE_OF_A_KIND).score()).isEqualTo(9);
  }

  @Test
  public void scoreSumOfFourOfAKind() {
    assertThat(new YatzyGame(List.of(3, 3, 3, 3, 5), FOUR_OF_A_KIND).score()).isEqualTo(12);
    assertThat(new YatzyGame(List.of(5, 5, 5, 4, 5), FOUR_OF_A_KIND).score()).isEqualTo(20);
  }

  @Test
  public void scoreSmallStraight() {
    assertThat(new YatzyGame(List.of(1, 2, 3, 4, 5), SMALL_STRAIGHT).score()).isEqualTo(15);
    assertThat(new YatzyGame(List.of(2, 3, 4, 5, 1), SMALL_STRAIGHT).score()).isEqualTo(15);
    assertThat(new YatzyGame(List.of(1, 2, 2, 4, 5), SMALL_STRAIGHT).score()).isEqualTo(0);
  }

  @Test
  public void scoreLargeStraight() {
    assertThat(new YatzyGame(List.of(6, 2, 3, 4, 5), LARGE_STRAIGHT).score()).isEqualTo(20);
    assertThat(new YatzyGame(List.of(2, 3, 4, 5, 6), LARGE_STRAIGHT).score()).isEqualTo(20);
    assertThat(new YatzyGame(List.of(1, 2, 2, 4, 5), LARGE_STRAIGHT).score()).isEqualTo(0);
  }

  @Test
  public void fullHouse() {
    assertThat(new YatzyGame(List.of(6, 2, 2, 2, 6), FULL_HOUSE).score()).isEqualTo(18);
    assertThat(new YatzyGame(List.of(2, 3, 4, 5, 6), FULL_HOUSE).score()).isEqualTo(0);
    assertThat(new YatzyGame(List.of(2, 2, 3, 3, 4), FULL_HOUSE).score()).isEqualTo(0);
    assertThat(new YatzyGame(List.of(4, 4, 4, 4, 4), FULL_HOUSE).score()).isEqualTo(0);
  }
}
