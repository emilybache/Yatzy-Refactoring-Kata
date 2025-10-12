package yatzy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import yatzy.yatzy1.Yatzy1

class Yatzy1Tests extends AnyFunSuite with Matchers {
  test("Chance scores sum of all dice") {
    val expected = 15
    val actual = Yatzy1.chance(2, 3, 4, 5, 1)

    assert(actual == expected)
    assert(Yatzy1.chance(3, 3, 4, 5, 1) == 16)
  }

  test("test_1s") {
    assert(Yatzy1.ones(1, 2, 3, 4, 5) == 1)
    assert(Yatzy1.ones(1, 2, 1, 4, 5) == 2)
    assert(Yatzy1.ones(6, 2, 2, 4, 5) == 0)
    assert(Yatzy1.ones(1, 2, 1, 1, 1) == 4)
  }

  test("test_2s") {
    assert(Yatzy1.twos(1, 2, 3, 2, 6) == 4)
    assert(Yatzy1.twos(2, 2, 2, 2, 2) == 10)
  }

  test("test_3s") {
    assert(Yatzy1.threes(1, 2, 3, 2, 3) == 6)
    assert(Yatzy1.threes(2, 3, 3, 3, 3) == 12)
  }

  test("test_5s") {
    assert(new Yatzy1(4, 4, 4, 5, 5).fives() == 10)
    assert(new Yatzy1(4, 4, 5, 5, 5).fives() == 15)
    assert(new Yatzy1(4, 5, 5, 5, 5).fives() == 20)
  }

  test("four of a knd") {
    assert(Yatzy1.fourOfAKind(3, 3, 3, 3, 5) == 12)
    assert(Yatzy1.fourOfAKind(5, 5, 5, 4, 5) == 20)
    assert(Yatzy1.fourOfAKind(3, 3, 3, 3, 3) == 12)
  }

  test("test_4s") {
    assert(new Yatzy1(4, 4, 4, 5, 5).fours() == 12)
    assert(new Yatzy1(4, 4, 5, 5, 5).fours() == 8)
    assert(new Yatzy1(4, 5, 5, 5, 5).fours() == 4)
  }

  test("fullHouse") {
    assert(Yatzy1.fullHouse(6, 2, 2, 2, 6) == 18)
    assert(Yatzy1.fullHouse(2, 3, 4, 5, 6) == 0)
  }

  test("largeStraight") {
    assert(Yatzy1.largeStraight(6, 2, 3, 4, 5) == 20)
    assert(Yatzy1.largeStraight(2, 3, 4, 5, 6) == 20)
    assert(Yatzy1.largeStraight(1, 2, 2, 4, 5) == 0)
  }

  test("one Pair") {
    assert(Yatzy1.scorePair(3, 4, 3, 5, 6) == 6)
    assert(Yatzy1.scorePair(5, 3, 3, 3, 5) == 10)
    assert(Yatzy1.scorePair(5, 3, 6, 6, 5) == 12)
  }

  test("sixes") {
    assert(new Yatzy1(4, 4, 4, 5, 5).Sixes() == 0)
    assert(new Yatzy1(4, 4, 6, 5, 5).Sixes() == 6)
    assert(new Yatzy1(6, 5, 6, 6, 5).Sixes() == 18)
  }

  test("smallStraight") {
    assert(Yatzy1.smallStraight(1, 2, 3, 4, 5) == 15)
    assert(Yatzy1.smallStraight(2, 3, 4, 5, 1) == 15)
    assert(Yatzy1.smallStraight(1, 2, 2, 4, 5) == 0)
  }

  test("three_of_a_kind") {
    assert(Yatzy1.threeOfAKind(3, 3, 3, 4, 5) == 9)
    assert(Yatzy1.threeOfAKind(5, 3, 5, 4, 5) == 15)
    assert(Yatzy1.threeOfAKind(3, 3, 3, 3, 5) == 9)
  }

  test("two pair") {
    assert(Yatzy1.twoPair(3, 3, 5, 4, 5) == 16)
    assert(Yatzy1.twoPair(3, 3, 5, 5, 5) == 16)
  }

  test("Yatzy2 scores 50") {
    val expected = 50
    val actual = Yatzy1.Yatzy(4, 4, 4, 4, 4)
    assert(actual == expected)
    assert(Yatzy1.Yatzy(6, 6, 6, 6, 6) == 50)
    assert(Yatzy1.Yatzy(6, 6, 6, 6, 3) == 0)
  }
}
