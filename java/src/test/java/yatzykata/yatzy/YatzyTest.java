package yatzykata.yatzy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YatzyTest {

  @Test
  public void scoreTheSumOfAllDice() {
    assertThat(Yatzy.chance(2, 3, 4, 5, 1)).isEqualTo(15);
    assertThat(Yatzy.chance(3, 3, 4, 5, 1)).isEqualTo(16);
  }

  @Test
  public void score50() {
    assertThat(Yatzy.yatzy(4, 4, 4, 4, 4)).isEqualTo(50);
    assertThat(Yatzy.yatzy(6, 6, 6, 6, 6)).isEqualTo(50);
    assertThat(Yatzy.yatzy(6, 6, 6, 6, 3)).isEqualTo(0);
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
  public void one_pair() {
    Assertions.assertEquals(6, Yatzy.score_pair(3, 4, 3, 5, 6));
    Assertions.assertEquals(10, Yatzy.score_pair(5, 3, 3, 3, 5));
    Assertions.assertEquals(12, Yatzy.score_pair(5, 3, 6, 6, 5));
  }

  @Test
  public void two_Pair() {
    Assertions.assertEquals(16, Yatzy.two_pair(3, 3, 5, 4, 5));
    Assertions.assertEquals(16, Yatzy.two_pair(3, 3, 5, 5, 5));
  }

  @Test
  public void three_of_a_kind() {
    Assertions.assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
    Assertions.assertEquals(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5));
    Assertions.assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
  }

  @Test
  public void four_of_a_knd() {
    Assertions.assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
    Assertions.assertEquals(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5));
    Assertions.assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 3));
  }

  @Test
  public void smallStraight() {
    Assertions.assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
    Assertions.assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
    Assertions.assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
  }

  @Test
  public void largeStraight() {
    Assertions.assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
    Assertions.assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
    Assertions.assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
  }

  @Test
  public void fullHouse() {
    Assertions.assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
    Assertions.assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
  }
}
