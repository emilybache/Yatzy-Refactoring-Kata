package yatzykata.yatzy;

import static org.assertj.core.api.Assertions.assertThat;
import static yatzykata.yatzy.domain.category.CategoryType.CHANCE;
import static yatzykata.yatzy.domain.category.CategoryType.YATZY;

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
    assertThat(YatzyGame.ones(1, 2, 3, 4, 5)).isEqualTo(1);
    assertThat(YatzyGame.ones(1, 2, 1, 4, 5)).isEqualTo(2);
    assertThat(YatzyGame.ones(6, 2, 2, 4, 5)).isEqualTo(0);
    assertThat(YatzyGame.ones(1, 2, 1, 1, 1)).isEqualTo(4);
  }

  @Test
  public void scoreSumOfTwos() {
    assertThat(YatzyGame.twos(1, 2, 3, 2, 6)).isEqualTo(4);
    assertThat(YatzyGame.twos(2, 2, 2, 2, 2)).isEqualTo(10);
  }

  @Test
  public void scoreSumOfThrees() {
    assertThat(YatzyGame.threes(1, 2, 3, 2, 3)).isEqualTo(6);
    assertThat(YatzyGame.threes(2, 3, 3, 3, 3)).isEqualTo(12);
  }

  @Test
  public void scoreSumOfFours() {
    assertThat(YatzyGame.fours(4, 4, 4, 5, 5)).isEqualTo(12);
    assertThat(YatzyGame.fours(4, 4, 5, 5, 5)).isEqualTo(8);
    assertThat(YatzyGame.fours(4, 5, 5, 5, 5)).isEqualTo(4);
  }

  @Test
  public void scoreSumOfFives() {
    assertThat(YatzyGame.fives(4, 4, 4, 5, 5)).isEqualTo(10);
    assertThat(YatzyGame.fives(4, 4, 5, 5, 5)).isEqualTo(15);
    assertThat(YatzyGame.fives(4, 5, 5, 5, 5)).isEqualTo(20);
  }

  @Test
  public void scoreSumOfSixes() {
    assertThat(YatzyGame.sixes(4, 4, 4, 5, 5)).isEqualTo(0);
    assertThat(YatzyGame.sixes(4, 4, 6, 5, 5)).isEqualTo(6);
    assertThat(YatzyGame.sixes(6, 5, 6, 6, 5)).isEqualTo(18);
  }

  @Test
  public void scoreSumOfOnePair() {
    assertThat(YatzyGame.pair(3, 4, 3, 5, 6)).isEqualTo(6);
    assertThat(YatzyGame.pair(5, 3, 3, 3, 5)).isEqualTo(10);
    assertThat(YatzyGame.pair(5, 3, 6, 6, 5)).isEqualTo(12);
  }

  @Test
  public void scoreSumOfTwoPairs() {
    assertThat(YatzyGame.twoPairs(3, 3, 5, 4, 5)).isEqualTo(16);
    assertThat(YatzyGame.twoPairs(3, 3, 5, 5, 5)).isEqualTo(16);
  }

  @Test
  public void scoreSumOfThreeOfAKind() {
    assertThat(YatzyGame.threeOfAKind(3, 3, 3, 4, 5)).isEqualTo(9);
    assertThat(YatzyGame.threeOfAKind(5, 3, 5, 4, 5)).isEqualTo(15);
    assertThat(YatzyGame.threeOfAKind(3, 3, 3, 3, 5)).isEqualTo(9);
    assertThat(YatzyGame.threeOfAKind(3, 3, 3, 3, 3)).isEqualTo(9);
  }

  @Test
  public void scoreSumOfFourOfAKind() {
    assertThat(YatzyGame.fourOfAKind(3, 3, 3, 3, 5)).isEqualTo(12);
    assertThat(YatzyGame.fourOfAKind(5, 5, 5, 4, 5)).isEqualTo(20);
  }

  @Test
  public void scoreSmallStraight() {
    assertThat(YatzyGame.smallStraight(1, 2, 3, 4, 5)).isEqualTo(15);
    assertThat(YatzyGame.smallStraight(2, 3, 4, 5, 1)).isEqualTo(15);
    assertThat(YatzyGame.smallStraight(1, 2, 2, 4, 5)).isEqualTo(0);
  }

  @Test
  public void scoreLargeStraight() {
    assertThat(YatzyGame.largeStraight(6, 2, 3, 4, 5)).isEqualTo(20);
    assertThat(YatzyGame.largeStraight(2, 3, 4, 5, 6)).isEqualTo(20);
    assertThat(YatzyGame.largeStraight(1, 2, 2, 4, 5)).isEqualTo(0);
  }

  @Test
  public void fullHouse() {
    assertThat(YatzyGame.fullHouse(6, 2, 2, 2, 6)).isEqualTo(18);
    assertThat(YatzyGame.fullHouse(2, 3, 4, 5, 6)).isEqualTo(0);
    assertThat(YatzyGame.fullHouse(2, 2, 3, 3, 4)).isEqualTo(0);
    assertThat(YatzyGame.fullHouse(4, 4, 4, 4, 4)).isEqualTo(0);
  }
}
