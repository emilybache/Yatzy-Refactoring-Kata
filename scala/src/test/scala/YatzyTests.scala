import Yatzy.Yatzy
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class YatzyTests extends AnyFunSuite with Matchers {
  test("Chance scores sum of all dice") {
    val expected = 15
    val actual = Yatzy.chance(2, 3, 4, 5, 1)

    assert(actual == expected)
    assert(Yatzy.chance(3, 3, 4, 5, 1) == 16)
  }

  test("test_1s") {
    assert(Yatzy.ones(1, 2, 3, 4, 5) == 1)
    assert(Yatzy.ones(1, 2, 1, 4, 5) == 2)
    assert(Yatzy.ones(6, 2, 2, 4, 5) == 0)
    assert(Yatzy.ones(1, 2, 1, 1, 1) == 4)
  }

  test("test_2s") {
    assert(Yatzy.twos(1, 2, 3, 2, 6) == 4)
    assert(Yatzy.twos(2, 2, 2, 2, 2) == 10)
  }

  test("test_3s") {
    assert(Yatzy.threes(1, 2, 3, 2, 3) == 6)
    assert(Yatzy.threes(2, 3, 3, 3, 3) == 12)
  }

  test("test_5s") {
    assert(new Yatzy(4, 4, 4, 5, 5).fives() == 10)
    assert(new Yatzy(4, 4, 5, 5, 5).fives() == 15)
    assert(new Yatzy(4, 5, 5, 5, 5).fives() == 20)
  }

  test("four of a knd") {
    assert(Yatzy.fourOfAKind(3, 3, 3, 3, 5) == 12)
    assert(Yatzy.fourOfAKind(5, 5, 5, 4, 5) == 20)
    assert(Yatzy.fourOfAKind(3, 3, 3, 3, 3) == 12)
  }

  test("test_4s") {
    assert(new Yatzy(4, 4, 4, 5, 5).fours() == 12)
    assert(new Yatzy(4, 4, 5, 5, 5).fours() == 8)
    assert(new Yatzy(4, 5, 5, 5, 5).fours() == 4)
  }

  test("fullHouse") {
    assert(Yatzy.fullHouse(6, 2, 2, 2, 6) == 18)
    assert(Yatzy.fullHouse(2, 3, 4, 5, 6) == 0)
  }

  test("largeStraight") {
    assert(Yatzy.largeStraight(6, 2, 3, 4, 5) == 20)
    assert(Yatzy.largeStraight(2, 3, 4, 5, 6) == 20)
    assert(Yatzy.largeStraight(1, 2, 2, 4, 5) == 0)
  }

  test("one Pair") {
    assert(Yatzy.scorePair(3, 4, 3, 5, 6) == 6)
    assert(Yatzy.scorePair(5, 3, 3, 3, 5) == 10)
    assert(Yatzy.scorePair(5, 3, 6, 6, 5) == 12)
  }

  test("sixes") {
    assert(new Yatzy(4, 4, 4, 5, 5).Sixes() == 0)
    assert(new Yatzy(4, 4, 6, 5, 5).Sixes() == 6)
    assert(new Yatzy(6, 5, 6, 6, 5).Sixes() == 18)
  }

  test("smallStraight") {
    assert(Yatzy.smallStraight(1, 2, 3, 4, 5) == 15)
    assert(Yatzy.smallStraight(2, 3, 4, 5, 1) == 15)
    assert(Yatzy.smallStraight(1, 2, 2, 4, 5) == 0)
  }

  test("three_of_a_kind") {
    assert(Yatzy.threeOfAKind(3, 3, 3, 4, 5) == 9)
    assert(Yatzy.threeOfAKind(5, 3, 5, 4, 5) == 15)
    assert(Yatzy.threeOfAKind(3, 3, 3, 3, 5) == 9)
  }

  test("two pair") {
    assert(Yatzy.twoPair(3, 3, 5, 4, 5) == 16)
    assert(Yatzy.twoPair(3, 3, 5, 5, 5) == 16)
  }

  test("Yatzy scores 50") {
    val expected = 50
    val actual = Yatzy.Yatzy(4, 4, 4, 4, 4)
    assert(actual == expected)
    assert(Yatzy.Yatzy(6, 6, 6, 6, 6) == 50)
    assert(Yatzy.Yatzy(6, 6, 6, 6, 3) == 0)
  }
}
