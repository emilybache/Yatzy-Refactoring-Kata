package yatzy

import org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations
import org.lambda.functions.Function5
import org.junit.jupiter.api.Test
import yatzy.yatzy1.Yatzy1

class YatzyApprovalTests:
  // MUST be boxed java.lang.Integer for the Java API
  private val DICE_VALUES: Array[Integer] = Array(
    Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3),
    Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6)
  )

  @Test
  def  chance_scores_sum_of_all_dice(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.chance(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def yatzy_score_50(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.yatzy(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def ones(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.ones(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def twos(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.twos(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def threes(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.threes(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def fours(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.scorePair(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def one_pair(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.scorePair(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def two_Pair(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.twoPair(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def three_of_a_kind(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.threeOfAKind(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def four_of_a_kind(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.fourOfAKind(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def small_straight(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.smallStraight(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def large_straight(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.largeStraight(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )

  @Test
  def full_house(): Unit =
    verifyAllCombinations(
      (d1: Integer, d2: Integer, d3: Integer, d4: Integer, d5: Integer) => Integer.valueOf(Yatzy1.fullHouse(d1, d2, d3, d4, d5)),
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES,
      DICE_VALUES
    )
