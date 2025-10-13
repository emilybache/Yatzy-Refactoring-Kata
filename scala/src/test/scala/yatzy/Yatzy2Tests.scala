package yatzy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import yatzy.yatzy2.Yatzy2
import yatzy.yatzy2.Yatzy2.*

class Yatzy2Tests extends AnyFunSuite with Matchers {
  val yatzy2  = new Yatzy2
  test("Chance scores sum of all dice") {
    assert(yatzy2.score(List(2, 3, 4, 5, 1), "CHANCE") == 15)
    assert(yatzy2.score(List(3, 3, 4, 5, 1), "CHANCE") == 16)
  }

  test("test_1s") {
    assert(yatzy2.score(List(1, 2, 3, 4, 5), "ONES") == 1)
    assert(yatzy2.score(List(1, 2, 1, 4, 5), "ONES") == 2)
    assert(yatzy2.score(List(6, 2, 2, 4, 5), "ONES") == 0)
    assert(yatzy2.score(List(1, 2, 1, 1, 1), "ONES") == 4)
  }

  test("test_2s") {
    assert(yatzy2.score(List(1, 2, 3, 2, 6), "TWOS") == 4)
    assert(yatzy2.score(List(2, 2, 2, 2, 2), "TWOS") == 10)
  }

  test("test_3s") {
    assert(yatzy2.score(List(1, 2, 3, 2, 3), "THREES") == 6)
    assert(yatzy2.score(List(2, 3, 3, 3, 3), "THREES") == 12)
  }

  test("test_5s") {
    assert(yatzy2.score(List(4, 4, 4, 5, 5), "FIVES")  == 10)
    assert(yatzy2.score(List(4, 4, 5, 5, 5), "FIVES")  == 15)
    assert(yatzy2.score(List(4, 5, 5, 5, 5), "FIVES")  == 20)
  }

  test("four of a knd") {
    assert(yatzy2.score(List(3, 3, 3, 3, 5), "FOUR_OF_A_KIND") == 12)
    assert(yatzy2.score(List(5, 5, 5, 4, 5), "FOUR_OF_A_KIND") == 20)
    assert(yatzy2.score(List(3, 3, 3, 3, 3), "FOUR_OF_A_KIND") == 12)
  }

  test("test_4s") {
    assert(yatzy2.score(List(4, 4, 4, 5, 5), "FOURS") == 12)
    assert(yatzy2.score(List(4, 4, 5, 5, 5), "FOURS") == 8)
    assert(yatzy2.score(List(4, 5, 5, 5, 5), "FOURS") == 4)
  }

  test("fullHouse") {
    assert(yatzy2.score(List(6, 2, 2, 2, 6), "FULL_HOUSE") == 18)
    assert(yatzy2.score(List(2, 3, 4, 5, 6), "FULL_HOUSE") == 0)
  }

  test("largeStraight") {
    assert(yatzy2.score(List(6, 2, 3, 4, 5), "LARGE_STRAIGHT") == 20)
    assert(yatzy2.score(List(2, 3, 4, 5, 6), "LARGE_STRAIGHT") == 20)
    assert(yatzy2.score(List(1, 2, 2, 4, 5), "LARGE_STRAIGHT") == 0)
  }

  test("one Pair") {
    assert(yatzy2.score(List(3, 4, 3, 5, 6), "PAIR") == 6)
    assert(yatzy2.score(List(5, 3, 3, 3, 5), "PAIR") == 10)
    assert(yatzy2.score(List(5, 3, 6, 6, 5), "PAIR") == 12)
  }

  test("sixes") {
    assert(yatzy2.score(List(4, 4, 4, 5, 5), "SIXES") == 0)
    assert(yatzy2.score(List(4, 4, 6, 5, 5), "SIXES") == 6)
    assert(yatzy2.score(List(6, 5, 6, 6, 5), "SIXES") == 18)
  }

  test("smallStraight") {
    assert(yatzy2.score(List(1, 2, 3, 4, 5), "SMALL_STRAIGHT") == 15)
    assert(yatzy2.score(List(2, 3, 4, 5, 1), "SMALL_STRAIGHT") == 15)
    assert(yatzy2.score(List(1, 2, 2, 4, 5), "SMALL_STRAIGHT") == 0)
  }

  test("three_of_a_kind") {
    assert(yatzy2.score(List(3, 3, 3, 4, 5), "THREE_OF_A_KIND") == 9)
    assert(yatzy2.score(List(5, 3, 5, 4, 5), "THREE_OF_A_KIND") == 15)
    assert(yatzy2.score(List(3, 3, 3, 3, 5), "THREE_OF_A_KIND") == 9)
  }

  test("two pair") {
    assert(yatzy2.score(List(3, 3, 5, 4, 5), "TWO_PAIRS") == 16)
    assert(yatzy2.score(List(3, 3, 5, 5, 5), "TWO_PAIRS") == 16)
  }

  test("yatzy2 scores 50") {
    assert(yatzy2.score(List(4, 4, 4, 4, 4), "YATZY") == 50)
    assert(yatzy2.score(List(6, 6, 6, 6, 6), "YATZY") == 50)
    assert(yatzy2.score(List(6, 6, 6, 6, 3), "YATZY") == 0)
  }
}
