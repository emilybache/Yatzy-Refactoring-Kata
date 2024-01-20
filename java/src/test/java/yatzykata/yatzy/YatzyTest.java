package yatzykata.yatzy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  public void test_1s() {
    assertTrue(Yatzy.ones(1, 2, 3, 4, 5) == 1);
    Assertions.assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
    Assertions.assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
    Assertions.assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
  }

  @Test
  public void test_2s() {
    Assertions.assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
    Assertions.assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
  }

  @Test
  public void test_threes() {
    Assertions.assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
    Assertions.assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
  }

  @Test
  public void fours_test() {
    Assertions.assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
    Assertions.assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
    Assertions.assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
  }

  @Test
  public void fives() {
    Assertions.assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
    Assertions.assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
    Assertions.assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
  }

  @Test
  public void sixes_test() {
    Assertions.assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
    Assertions.assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
    Assertions.assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
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
