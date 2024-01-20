package yatzykata.yatzy;

import static org.assertj.core.api.Assertions.assertThat;
import static yatzykata.yatzy.domain.category.CategoryType.CHANCE;
import static yatzykata.yatzy.domain.category.CategoryType.YATZY;

import org.junit.jupiter.api.Test;

public class YatzyTest {

  @Test
  public void scoreTheSumOfAllDice() {
    assertThat(new Yatzy(CHANCE, 2, 3, 4, 5, 1).score()).isEqualTo(15);
    assertThat(new Yatzy(CHANCE, 3, 3, 4, 5, 1).score()).isEqualTo(16);
  }

  @Test
  public void score50() {
    assertThat(new Yatzy(YATZY, 4, 4, 4, 4, 4).score()).isEqualTo(50);
    assertThat(new Yatzy(YATZY, 6, 6, 6, 6, 6).score()).isEqualTo(50);
    assertThat(new Yatzy(YATZY, 6, 6, 6, 6, 3).score()).isEqualTo(0);
  }

  @Test
  public void scoreSumOfOnes() {
    assertThat(Yatzy.ones(1, 2, 3, 4, 5)).isEqualTo(1);
    assertThat(Yatzy.ones(1, 2, 1, 4, 5)).isEqualTo(2);
    assertThat(Yatzy.ones(6, 2, 2, 4, 5)).isEqualTo(0);
    assertThat(Yatzy.ones(1, 2, 1, 1, 1)).isEqualTo(4);
  }

  @Test
  public void scoreSumOfTwos() {
    assertThat(Yatzy.twos(1, 2, 3, 2, 6)).isEqualTo(4);
    assertThat(Yatzy.twos(2, 2, 2, 2, 2)).isEqualTo(10);
  }

  @Test
  public void scoreSumOfThrees() {
    assertThat(Yatzy.threes(1, 2, 3, 2, 3)).isEqualTo(6);
    assertThat(Yatzy.threes(2, 3, 3, 3, 3)).isEqualTo(12);
  }

  @Test
  public void scoreSumOfFours() {
    assertThat(Yatzy.fours(4, 4, 4, 5, 5)).isEqualTo(12);
    assertThat(Yatzy.fours(4, 4, 5, 5, 5)).isEqualTo(8);
    assertThat(Yatzy.fours(4, 5, 5, 5, 5)).isEqualTo(4);
  }

  @Test
  public void scoreSumOfFives() {
    assertThat(Yatzy.fives(4, 4, 4, 5, 5)).isEqualTo(10);
    assertThat(Yatzy.fives(4, 4, 5, 5, 5)).isEqualTo(15);
    assertThat(Yatzy.fives(4, 5, 5, 5, 5)).isEqualTo(20);
  }

  @Test
  public void scoreSumOfSixes() {
    assertThat(Yatzy.sixes(4, 4, 4, 5, 5)).isEqualTo(0);
    assertThat(Yatzy.sixes(4, 4, 6, 5, 5)).isEqualTo(6);
    assertThat(Yatzy.sixes(6, 5, 6, 6, 5)).isEqualTo(18);
  }

  @Test
  public void scoreSumOfOnePair() {
    assertThat(Yatzy.pair(3, 4, 3, 5, 6)).isEqualTo(6);
    assertThat(Yatzy.pair(5, 3, 3, 3, 5)).isEqualTo(10);
    assertThat(Yatzy.pair(5, 3, 6, 6, 5)).isEqualTo(12);
  }

  @Test
  public void scoreSumOfTwoPairs() {
    assertThat(Yatzy.twoPairs(3, 3, 5, 4, 5)).isEqualTo(16);
    assertThat(Yatzy.twoPairs(3, 3, 5, 5, 5)).isEqualTo(16);
  }

  @Test
  public void scoreSumOfThreeOfAKind() {
    assertThat(Yatzy.threeOfAKind(3, 3, 3, 4, 5)).isEqualTo(9);
    assertThat(Yatzy.threeOfAKind(5, 3, 5, 4, 5)).isEqualTo(15);
    assertThat(Yatzy.threeOfAKind(3, 3, 3, 3, 5)).isEqualTo(9);
    assertThat(Yatzy.threeOfAKind(3, 3, 3, 3, 3)).isEqualTo(9);
  }

  @Test
  public void scoreSumOfFourOfAKind() {
    assertThat(Yatzy.fourOfAKind(3, 3, 3, 3, 5)).isEqualTo(12);
    assertThat(Yatzy.fourOfAKind(5, 5, 5, 4, 5)).isEqualTo(20);
  }

  @Test
  public void scoreSmallStraight() {
    assertThat(Yatzy.smallStraight(1, 2, 3, 4, 5)).isEqualTo(15);
    assertThat(Yatzy.smallStraight(2, 3, 4, 5, 1)).isEqualTo(15);
    assertThat(Yatzy.smallStraight(1, 2, 2, 4, 5)).isEqualTo(0);
  }

  @Test
  public void scoreLargeStraight() {
    assertThat(Yatzy.largeStraight(6, 2, 3, 4, 5)).isEqualTo(20);
    assertThat(Yatzy.largeStraight(2, 3, 4, 5, 6)).isEqualTo(20);
    assertThat(Yatzy.largeStraight(1, 2, 2, 4, 5)).isEqualTo(0);
  }

  @Test
  public void fullHouse() {
    assertThat(Yatzy.fullHouse(6, 2, 2, 2, 6)).isEqualTo(18);
    assertThat(Yatzy.fullHouse(2, 3, 4, 5, 6)).isEqualTo(0);
    assertThat(Yatzy.fullHouse(2, 2, 3, 3, 4)).isEqualTo(0);
    assertThat(Yatzy.fullHouse(4, 4, 4, 4, 4)).isEqualTo(0);
  }
}
