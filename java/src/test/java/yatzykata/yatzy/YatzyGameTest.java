package yatzykata.yatzy;

import static org.assertj.core.api.Assertions.assertThat;
import static yatzykata.yatzy.domain.category.model.CategoryType.*;

import org.junit.jupiter.api.Test;

public class YatzyGameTest {

  @Test
  public void scoreTheSumOfAllDice() {
    assertThat(new YatzyGame(CHANCE, 2, 3, 4, 5, 1).score()).isEqualTo(15);
    assertThat(new YatzyGame(CHANCE, 3, 3, 4, 5, 1).score()).isEqualTo(16);
  }

  @Test
  public void score50() {
    assertThat(new YatzyGame(YATZY, 4, 4, 4, 4, 4).score()).isEqualTo(50);
    assertThat(new YatzyGame(YATZY, 6, 6, 6, 6, 6).score()).isEqualTo(50);
    assertThat(new YatzyGame(YATZY, 6, 6, 6, 6, 3).score()).isEqualTo(0);
  }

  @Test
  public void scoreSumOfOnes() {
    assertThat(new YatzyGame(ONES, 1, 2, 3, 4, 5).score()).isEqualTo(1);
    assertThat(new YatzyGame(ONES, 1, 2, 1, 4, 5).score()).isEqualTo(2);
    assertThat(new YatzyGame(ONES, 6, 2, 2, 4, 5).score()).isEqualTo(0);
    assertThat(new YatzyGame(ONES, 1, 2, 1, 1, 1).score()).isEqualTo(4);
  }

  @Test
  public void scoreSumOfTwos() {
    assertThat(new YatzyGame(TWOS, 1, 2, 3, 2, 6).score()).isEqualTo(4);
    assertThat(new YatzyGame(TWOS, 2, 2, 2, 2, 2).score()).isEqualTo(10);
  }

  @Test
  public void scoreSumOfThrees() {
    assertThat(new YatzyGame(THREES, 1, 2, 3, 2, 3).score()).isEqualTo(6);
    assertThat(new YatzyGame(THREES, 2, 3, 3, 3, 3).score()).isEqualTo(12);
  }

  @Test
  public void scoreSumOfFours() {
    assertThat(new YatzyGame(FOURS, 4, 4, 4, 5, 5).score()).isEqualTo(12);
    assertThat(new YatzyGame(FOURS, 4, 4, 5, 5, 5).score()).isEqualTo(8);
    assertThat(new YatzyGame(FOURS, 4, 5, 5, 5, 5).score()).isEqualTo(4);
  }

  @Test
  public void scoreSumOfFives() {
    assertThat(new YatzyGame(FIVES, 4, 4, 4, 5, 5).score()).isEqualTo(10);
    assertThat(new YatzyGame(FIVES, 4, 4, 5, 5, 5).score()).isEqualTo(15);
    assertThat(new YatzyGame(FIVES, 4, 5, 5, 5, 5).score()).isEqualTo(20);
  }

  @Test
  public void scoreSumOfSixes() {
    assertThat(new YatzyGame(SIXES, 4, 4, 4, 5, 5).score()).isEqualTo(0);
    assertThat(new YatzyGame(SIXES, 4, 4, 6, 5, 5).score()).isEqualTo(6);
    assertThat(new YatzyGame(SIXES, 6, 5, 6, 6, 5).score()).isEqualTo(18);
  }

  @Test
  public void scoreSumOfOnePair() {
    assertThat(new YatzyGame(PAIR, 3, 4, 3, 5, 6).score()).isEqualTo(6);
    assertThat(new YatzyGame(PAIR, 5, 3, 3, 3, 5).score()).isEqualTo(10);
    assertThat(new YatzyGame(PAIR, 5, 3, 6, 6, 5).score()).isEqualTo(12);
  }

  @Test
  public void scoreSumOfTwoPairs() {
    assertThat(new YatzyGame(TWO_PAIRS, 3, 3, 5, 4, 5).score()).isEqualTo(16);
    assertThat(new YatzyGame(TWO_PAIRS, 3, 3, 5, 5, 5).score()).isEqualTo(16);
    assertThat(new YatzyGame(TWO_PAIRS, 3, 3, 4, 5, 6).score()).isEqualTo(0);
  }

  @Test
  public void scoreSumOfThreeOfAKind() {
    assertThat(new YatzyGame(THREE_OF_A_KIND, 3, 3, 3, 4, 5).score()).isEqualTo(9);
    assertThat(new YatzyGame(THREE_OF_A_KIND, 5, 3, 5, 4, 5).score()).isEqualTo(15);
    assertThat(new YatzyGame(THREE_OF_A_KIND, 3, 3, 3, 3, 5).score()).isEqualTo(9);
    assertThat(new YatzyGame(THREE_OF_A_KIND, 3, 3, 3, 3, 3).score()).isEqualTo(9);
  }

  @Test
  public void scoreSumOfFourOfAKind() {
    assertThat(new YatzyGame(FOUR_OF_A_KIND, 3, 3, 3, 3, 5).score()).isEqualTo(12);
    assertThat(new YatzyGame(FOUR_OF_A_KIND, 5, 5, 5, 4, 5).score()).isEqualTo(20);
  }

  @Test
  public void scoreSmallStraight() {
    assertThat(new YatzyGame(SMALL_STRAIGHT, 1, 2, 3, 4, 5).score()).isEqualTo(15);
    assertThat(new YatzyGame(SMALL_STRAIGHT, 2, 3, 4, 5, 1).score()).isEqualTo(15);
    assertThat(new YatzyGame(SMALL_STRAIGHT, 1, 2, 2, 4, 5).score()).isEqualTo(0);
  }

  @Test
  public void scoreLargeStraight() {
    assertThat(new YatzyGame(LARGE_STRAIGHT, 6, 2, 3, 4, 5).score()).isEqualTo(20);
    assertThat(new YatzyGame(LARGE_STRAIGHT, 2, 3, 4, 5, 6).score()).isEqualTo(20);
    assertThat(new YatzyGame(LARGE_STRAIGHT, 1, 2, 2, 4, 5).score()).isEqualTo(0);
  }

  @Test
  public void fullHouse() {
    assertThat(new YatzyGame(FULL_HOUSE, 6, 2, 2, 2, 6).score()).isEqualTo(18);
    assertThat(new YatzyGame(FULL_HOUSE, 2, 3, 4, 5, 6).score()).isEqualTo(0);
    assertThat(new YatzyGame(FULL_HOUSE, 2, 2, 3, 3, 4).score()).isEqualTo(0);
    assertThat(new YatzyGame(FULL_HOUSE, 4, 4, 4, 4, 4).score()).isEqualTo(0);
  }
}
