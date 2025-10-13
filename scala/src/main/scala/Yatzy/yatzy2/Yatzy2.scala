package yatzy.yatzy2

import yatzy.{YatzyCalculator, YatzyCategory}
import yatzy.YatzyCategory.*

import scala.util.boundary
import scala.util.boundary.break

object Yatzy2 { private val DICE_VALUES = List(6, 5, 4, 3, 2, 1) }
class Yatzy2 extends YatzyCalculator {
//  override def validCategories: List[String] = util.Arrays.stream(YatzyCategory.values).map(_.toString).collect(Collectors.toList)
  override def validCategories: List[String] = YatzyCategory.values.map(_.toString).toList

  override def score(dice: List[Int], categoryName: String): Int = {
    val category = YatzyCategory.valueOf(categoryName)
    // calculate dice frequencies
    val diceFrequencies: collection.mutable.Map[Int, Int] = collection.mutable.Map()
//    import scala.collection.JavaConversions._

    for (i <- Yatzy2.DICE_VALUES) { diceFrequencies.put(i, 0) }
    for (die <- dice) { diceFrequencies.put(die, diceFrequencies(die) + 1) }
    // calculate the score
    var result = 0
    category match {
      case CHANCE =>
        // chance sums the dice
        result = dice.sum

      case YATZY =>
        // score for yatzy if all dice are the same
        var yatzyResult = 0
        if (diceFrequencies.values.toList.contains(5)) yatzyResult = 50
        result = yatzyResult

      case ONES =>
        // sum all the ones
        result = diceFrequencies(1)

      case TWOS =>
        // sum all the twos
        result = diceFrequencies(2) * 2

      case THREES =>
        // sum all the threes
        result = diceFrequencies(3) * 3

      case FOURS =>
        // sum all the fours
        result = diceFrequencies(4) * 4

      case FIVES =>
        // sum all the fives
        result = diceFrequencies(5) * 5

      case SIXES =>
        // sum all the sixes
        result = diceFrequencies(6) * 6

      case PAIR =>
        // score pair if two dice are the same
        var pairResult = 0
        // score highest pair if there is more than one
        boundary {
          for (i <- Yatzy2.DICE_VALUES) {
            if (diceFrequencies(i) >= 2) {
              pairResult = i * 2
              break()

            }
          }
        }
        result = pairResult

      case THREE_OF_A_KIND =>
        // score if three dice are the same
        var threeKindResult = 0
        boundary {
          for (i <- Yatzy2.DICE_VALUES) {
            if (diceFrequencies(i) >= 3) {
              threeKindResult = i * 3
              break()
            }
          }
        }
        result = threeKindResult

      case FOUR_OF_A_KIND =>
        // score if four dice are the same
        var fourKindResult = 0
        boundary {
          for (i <- Yatzy2.DICE_VALUES) {
            if (diceFrequencies(i) >= 4) {
              fourKindResult = i * 4
              break()
            }
          }
        }
        result = fourKindResult

      case SMALL_STRAIGHT =>
        // score if dice contains 1,2,3,4,5
        var smallStraightResult = 0
        var count = 0L
        for (frequency <- diceFrequencies.values) { if (frequency eq 1) count += 1 }
        if (count == 5 && (diceFrequencies(6) eq 0)) {
          for (die <- dice) { smallStraightResult += die }
        }
        result = smallStraightResult

      case LARGE_STRAIGHT =>
        // score if dice contains 2,3,4,5,6
        var largeStraightResult = 0
        var straightCount = 0L
        for (frequency <- diceFrequencies.values) { if (frequency eq 1) straightCount += 1 }
        if (straightCount == 5 && (diceFrequencies(1) eq 0)) {
          for (die <- dice) { largeStraightResult += die }
        }
        result = largeStraightResult

      case TWO_PAIRS =>
        // score if there are two pairs
        var twoPairResult = 0
        var pairCount = 0L
        for (frequency <- diceFrequencies.values) { if (frequency >= 2) pairCount += 1 }
        if (pairCount == 2) {
          for (i <- Yatzy2.DICE_VALUES) {
            if (diceFrequencies(i) >= 2) twoPairResult += i * 2
          }
        }
        result = twoPairResult

      case FULL_HOUSE =>
        // score if there is a pair as well as three of a kind
        var fullHouseResult = 0
        if (
          diceFrequencies.values.toList.contains(2) && diceFrequencies.values.toList.contains(3)
        ) {
          for (die <- dice) { fullHouseResult += die }
        }
        result = fullHouseResult

      case _ =>
        result = 0
    }
    result
  }
}
